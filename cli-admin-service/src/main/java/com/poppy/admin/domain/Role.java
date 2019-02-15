package com.poppy.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * 角色
 *
 * @author jie
 * @date 2018-11-22
 */
@Getter
@Setter
public class Role implements Serializable {

    private Long id;

    private String name;

    private String remark;

    private Set<User> users;

    private Set<Permission> permissions;

    @JsonIgnore
    private Set<Menu> menus;

    private Timestamp createTime;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createDateTime=" + createTime +
                '}';
    }
}
