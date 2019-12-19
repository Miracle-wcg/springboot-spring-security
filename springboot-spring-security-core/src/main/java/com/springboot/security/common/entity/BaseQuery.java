package com.springboot.security.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Miracle.wcg
 * @Date 2019-12-08 22:29
 */
@Data
public class BaseQuery implements Serializable {
    private static final long serialVersionUID = -1270955014214820858L;
    @ApiModelProperty(value = "每页页数")
    private Long pageSize;
    @ApiModelProperty(value = "页码")
    private Long pageNo;
}
