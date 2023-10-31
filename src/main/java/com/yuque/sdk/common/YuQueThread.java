package com.yuque.sdk.common;

import com.yuque.sdk.client.YuQueClient;
import com.yuque.sdk.domain.DocsData;
import com.yuque.sdk.domain.ReposData;
import com.yuque.sdk.model.vo.DocMd;
import com.yuque.sdk.util.FileUtil;
import com.yuque.sdk.util.Func;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author nanchen
 * @Date 2023/10/27 14:49
 **/
@Data
@NoArgsConstructor
public class YuQueThread extends Thread {

    private ReposData reposData;

    private List<DocsData> docsDataList;

    private YuQueClient yuQueClient;

    private String outPath;

    public YuQueThread(ReposData reposData, List<DocsData> docsData, YuQueClient yuQueClient,String outPath) {
        this.reposData = reposData;
        this.docsDataList = docsData;
        this.outPath = outPath;
        if (this.yuQueClient == null) {
            this.yuQueClient = yuQueClient;
        }
    }

    @SneakyThrows
    @Override
    public void run() {
        String reposBasePath = Func.convertUrlPath(reposData.getUser().getLogin(), reposData.getSlug());
        for (DocsData docsData : docsDataList) {
            String docMdText = yuQueClient.getDocMdText(reposBasePath, docsData.getSlug(), docsData.getType());
            String reposName = Func.removeUnLegalFolderChar(reposData.getName());
            String fileName = Func.removeUnLegalFolderChar(docsData.getTitle());
            FileUtil.exportFile(docMdText,outPath+reposName+"\\",fileName+".md");
        }
    }
}
