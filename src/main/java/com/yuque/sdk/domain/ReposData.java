/**
  * Copyright 2023 json.cn 
  */
package com.yuque.sdk.domain;
import lombok.Data;

import java.util.Date;

/**
 * Auto-generated: 2023-10-27 11:21:33
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class ReposData {

    private long id;
    private String type;
    private String slug;
    private String name;
    private long user_id;
    private String description;
    private int items_count;
    private int likes_count;
    private int watches_count;
    private long creator_id;
    private Abilities abilities;
    private int isPublic;
    private int extend_private;
    private String scene;
    private String source;
    private Date created_at;
    private Date updated_at;
    private Date content_updated_at;
    private String pinned_at;
    private String archived_at;
    private int status;
    private String stack_id;
    private String rank;
    private String layout;
    private String doc_viewport;
    private String doc_typography;
    private String cover;
    private String comment_count;
    private String read_count;
    private int original;
    private int organization_id;
    private boolean enable_auto_publish;
    private boolean enable_automation;
    private boolean privacy_migrated;
    private User user;
    private String creator;
    private String _serializer;
}