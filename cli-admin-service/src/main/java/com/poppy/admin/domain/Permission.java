package com.poppy.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author jie
 * @date 2018-12-03
 */
@Getter
@Setter
public class Permission implements Serializable {

    private Long id;

    private String name;

    /**
     * 上级类目
     */
    @NotNull
    private Long pid;

    @NotBlank
    private String alias;

    @JsonIgnore
    private Set<Role> roles;

    private Timestamp createTime;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", alias='" + alias + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
