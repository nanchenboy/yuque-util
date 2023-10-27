/**
  * Copyright 2023 json.cn 
  */
package com.yuque.sdk.domain;
import lombok.Data;

import java.util.Date;

/**
 * Auto-generated: 2023-10-25 10:1:36
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class DocsData {

    private long id;
    private int space_id;
    private String type;
    private String sub_type;
    private String title;
    private String title_draft;
    private String tag;
    private String slug;
    private long user_id;
    private long book_id;
    private long last_editor_id;
    private String cover;
    private String description;
    private String custom_description;
    private String format;
    private int status;
    private int read_status;
    private int view_status;
    private int isPublic;
    private int draft_version;
    private int comments_count;
    private int likes_count;
    private Date content_updated_at;
    private Date created_at;
    private Date updated_at;
    private Date published_at;
    private Date first_published_at;
    private int word_count;
    private String selected_at;
    private String pinned_at;
    private Meta meta;
    private String read_count;
    private String editor_meta;
    private String editor_meta_draft;
    private String region;
    private boolean privacy_migrated;
    private String book;
    private String user;
    private String last_editor;
    private String share;
    private String _serializer;
}