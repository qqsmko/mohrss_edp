package com.mohress.edp.model;

import java.util.Date;

/**
 * 权限管理-权限信息
 *
 * Created by youtao.wan on 2017/6/5.
 */
public class TblAuthority {
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 权限Id
     */
    private String authorityId;
    /**
     * 权限名称(AUTH_*)
     * 约定以AUTH_起始
     */
    private String authorityName;
    /**
     * 权限说明
     */
    private String authorityDesc;
    /**
     * 提示信息
     */
    private String promptMessage;
    /**
     * 是否可使用
     */
    private boolean enable;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

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

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityDesc() {
        return authorityDesc;
    }

    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
