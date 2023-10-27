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
public class User {

    private long id;
    private String type;
    private String login;
    private String name;
    private String description;
    private String avatar;
    private String avatar_url;
    private int followers_count;
    private int following_count;
    private int status;
    private int isPublic;
    private String scene;
    private Date created_at;
    private Date updated_at;
    private Date expired_at;
    private boolean isPaid;
    private int member_level;
    private String memberLevelName;
    private boolean hasMemberLevel;
    private boolean isTopLevel;
    private boolean isNewbie;
    private String profile;
    private String organizationUser;
    private String _serializer;
}