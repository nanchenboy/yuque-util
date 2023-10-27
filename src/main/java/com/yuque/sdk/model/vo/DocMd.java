package com.yuque.sdk.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author nanchen
 * @Date 2023/10/27 14:27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocMd {

    //知识库名称
    private String reposName;

    //文档内容
    private String title;

    //文档标题
    private String content;
}
