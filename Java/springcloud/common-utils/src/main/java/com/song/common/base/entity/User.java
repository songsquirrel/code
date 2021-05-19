package com.song.common.base.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Song.X
 * Date: 2020/9/29
 * Description: user entity
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1752718690335607925L;
    @ApiModelProperty("用户ID")
    private String id;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("登录名")
    private String loginName;
}
