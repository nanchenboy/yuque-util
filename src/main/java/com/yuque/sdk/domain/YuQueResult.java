/**
  * Copyright 2023 json.cn 
  */
package com.yuque.sdk.domain;
import java.util.List;

/**
 * Auto-generated: 2023-10-25 10:1:36
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class YuQueResult {

    private Meta meta;
    private List<DocsData> docsData;
    public void setMeta(Meta meta) {
         this.meta = meta;
     }
     public Meta getMeta() {
         return meta;
     }

    public void setData(List<DocsData> data) {
         this.docsData = data;
     }
     public List<DocsData> getData() {
         return docsData;
     }

}