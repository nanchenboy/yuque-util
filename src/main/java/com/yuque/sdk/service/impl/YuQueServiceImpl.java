package com.yuque.sdk.service.impl;

import com.yuque.sdk.client.YuQueClient;
import com.yuque.sdk.common.YuQueThread;
import com.yuque.sdk.domain.DocsData;
import com.yuque.sdk.domain.ReposData;
import com.yuque.sdk.exception.YuqueException;
import com.yuque.sdk.model.vo.DocMd;
import com.yuque.sdk.service.YuQueService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * @Author nanchen
 * @Date 2023/10/27 13:50
 **/
@Service
@Slf4j
public class YuQueServiceImpl implements YuQueService {

    @Autowired
    YuQueClient yuQueClient;

    @Override
    public void exportCollaborateMd(String outPath) throws YuqueException {
        //获取协作知识库
        List<ReposData> reposDataList = yuQueClient.listCollaborateBooks();
        //获取所有知识库下所有的文档类型为md的信息（所在知识库，文档标题，内容）ReposData: 知识库， List<DocsData>：文档信息
        Map<ReposData, List<DocsData>> reposDataListMap = listReposDocMd(reposDataList);
        //导出
        for (ReposData reposData : reposDataListMap.keySet()) {
            export(reposData,reposDataListMap.get(reposData),outPath);
        }
        log.info("导出我协作的知识库文档结束");
    }

    @Override
    public void exportMyMd(String outPath) throws YuqueException {
        //获取协作知识库
        List<ReposData> reposDataList = yuQueClient.listMyBooks();
        //获取所有知识库下所有的文档类型为md的信息（所在知识库，文档标题，内容）ReposData: 知识库， List<DocsData>：文档信息
        Map<ReposData, List<DocsData>> reposDataListMap = listReposDocMd(reposDataList);
        //导出
        for (ReposData reposData : reposDataListMap.keySet()) {
            export(reposData,reposDataListMap.get(reposData),outPath);
        }
        log.info("导出我的知识库文档结束");
    }

    private Map<ReposData,List<DocsData>> listReposDocMd(List<ReposData> reposDataList) throws YuqueException {
        ArrayList<DocMd> docMds = new ArrayList<>();
        Map<ReposData, List<DocsData>> reposDataMap = new HashMap<>();
        for (ReposData reposData : reposDataList) {
            //根据知识库ID，获取知识库下所有的文档
            List<DocsData> docsDataList = yuQueClient.listDockByBookId(String.valueOf(reposData.getId()));
            //过滤出md类型的
            docsDataList = docsDataList.stream().filter(docsData -> docsData.getType().equals("Doc")).collect(Collectors.toList());
            reposDataMap.put(reposData,docsDataList);
        }
        return reposDataMap;
    }


    /**
     * 十个线程为一组获取文档信息
     **/
    @SneakyThrows
    private void export(ReposData reposData, List<DocsData> docsDataList, String outPath) {
        int start = 0;
        int size = docsDataList.size();
        for (int i = 0; i < size/10+1; i++) {
            int end = (i + 1) * 10 > size ? size : (i + 1) * 10;
            if (start >= size) {
                break;
            }
            List<DocsData> docsData = docsDataList.subList(start, end);
            start = end;
            new YuQueThread(reposData,docsData,yuQueClient,outPath).start();
        }
    }
}
