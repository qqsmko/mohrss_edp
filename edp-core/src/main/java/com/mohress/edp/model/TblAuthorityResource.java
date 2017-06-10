package com.mohress.edp.model;

/**
 * 权限控制-权限资源关联实体
 *
 * Created by youtao.wan on 2017/6/5.
 */
public class TblAuthorityResource {

    private Long id;

    private String authorityId;

    private String resourceId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
