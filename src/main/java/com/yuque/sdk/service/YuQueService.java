package com.yuque.sdk.service;

import com.yuque.sdk.exception.YuqueException;

/**
 * @Author nanchen
 * @Date 2023/10/27 13:50
 **/
public interface YuQueService {
    
    /**
     * @Description 导出语雀协作的知识库为md文档到指定路径
     * @Param  outPath 输出路径
     * @return void
     **/
    void exportCollaborateMd(String outPath) throws YuqueException;

    /**
     * @Description 导出语雀协作的知识库为md文档到指定路径
     * @Param  outPath 输出路径
     * @return void
     **/
    void exportMyMd(String outPath) throws YuqueException;
}
