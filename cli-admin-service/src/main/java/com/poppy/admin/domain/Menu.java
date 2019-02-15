package com.poppy.admin.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

/**
 * @author jie
 * @date 2018-12-17
 */
@Getter
@Setter
public class Menu {

    private Long id;

    private String name;

    private Long sort;

    private String path;

    private String component;

    private String icon;

    /**
     * 上级菜单ID
     */
    private Long pid;

    /**
     * 是否为外链 true/false
     */
    private Boolean iFrame;

    private Set<Role> roles;

    private Timestamp createTime;
}
