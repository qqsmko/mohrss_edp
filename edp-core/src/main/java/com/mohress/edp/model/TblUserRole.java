package com.mohress.edp.model;

/**
 * 权限管理-用户角色关联实体
 *
 * Created by youtao.wan on 2017/6/5.
 */
public class TblUserRole {
    private Long id;

    private String userId;

    private String roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
