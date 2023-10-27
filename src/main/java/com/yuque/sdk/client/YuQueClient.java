package com.yuque.sdk.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuque.sdk.exception.YuqueException;
import com.yuque.sdk.domain.DocsData;
import com.yuque.sdk.domain.HttpRespVo;
import com.yuque.sdk.domain.ReposData;
import com.yuque.sdk.util.Func;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author nanchen
 * @Date 2023/10/25 9:55
 * step1: F12获取语雀cookie
 * step2: 获取知识库文档列表
 * step3: 获取文档的md数据
 * step4: 解析md数据，导出为md格式
 * 无需氪金
 **/
@Component
public class YuQueClient extends HttpClientHolder {

    //获取md文档的内容需要添加的后缀
    private final String mdUrlSuffix = "/markdown?plain=true&linebreak=false&anchor=false";

    //协作知识库api path
    private final String collaborateBooksPath = "api/mine/collaborate_books";

    //协作知识库api path
    private final String myBooksPath = "api/mine/book_stacks";

    @Value("${yuQueApiBase}")
    private String yuQueApiBase;

    @Value("${cookie}")
    public void setAPPKEY(String cookie) {
        super.setCookie(cookie);
    }

    /**
     * @Description 根据bookId获取其下的文档信息
     * @Param  bookId
     * @return void
     **/
    public List<DocsData> listDockByBookId(String bookId) throws YuqueException {
        Map<String,String> para = new HashMap<String, String>();
        para.put("book_id",bookId);

        HttpGet httpGet = buildHttpGet(yuQueApiBase+"/api/docs",para);
        //发送请求
        HttpRespVo vo = doRequest(httpGet);
        //转jsonArr
        JSONArray jsonArray = JSONObject.parseObject(vo.getHttpContent()).getJSONArray("data");
        //转user
        List<DocsData> docsData = JSONObject.parseArray(jsonArray.toJSONString(), DocsData.class);
        return docsData;
    }

    /**
     * @return void
     * @Description 获取文本md内容
     * @Param reposBasePath 知识库基础路径
     * @Param slug 文本slug标志
     * @Param type 文本类型
     **/
    public String getDocMdText(String reposBasePath,String slug, String type) throws YuqueException {
        if (!type.equals("Doc")) {
            return "";
        }
        HttpGet httpGet = buildHttpGet(yuQueApiBase+Func.convertUrlPath(reposBasePath,slug,mdUrlSuffix));
        //发送请求
        HttpRespVo vo = doRequest(httpGet);
        return vo.getHttpContent();
    }

    //根据cookie获取协作知识库信息
    public List<ReposData> listCollaborateBooks() throws YuqueException {
        HttpGet httpGet = buildHttpGet(yuQueApiBase+collaborateBooksPath);
        //发送请求
        HttpRespVo vo = doRequest(httpGet);
        //转jsonArr
        JSONArray jsonArray = JSONObject.parseObject(vo.getHttpContent()).getJSONArray("data");
        //转user
        List<ReposData> reposData = JSONObject.parseArray(jsonArray.toJSONString(), ReposData.class);
        return reposData;
    }

    //根据cookie获取我的知识库信息
    public List<ReposData> listMyBooks() throws YuqueException {
        HttpGet httpGet = buildHttpGet(yuQueApiBase+myBooksPath);
        //发送请求
        HttpRespVo vo = doRequest(httpGet);
        //转jsonArr
        JSONArray jsonArray = JSONObject.parseObject(vo.getHttpContent()).getJSONArray("data");
        List<ReposData> reposDataList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            JSONArray books = jsonObject.getJSONArray("books");
            //转user
            List<ReposData> reposData = JSONObject.parseArray(books.toJSONString(), ReposData.class);
            reposDataList.addAll(reposData);
        }
        return reposDataList;
    }
}


