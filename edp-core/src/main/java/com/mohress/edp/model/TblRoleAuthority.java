package com.mohress.edp.model;

/**
 * 权限管理-角色权限关联实体
 *
 * Created by youtao.wan on 2017/6/5.
 */
public class TblRoleAuthority {

    private Long id;

    private String roleId;

    private String authorityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }
}
