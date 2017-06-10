package com.mohress.edp.dao;


import com.mohress.edp.model.TblRole;

/**
 * Created by youtao.wan on 2017/6/6.
 */
public interface TblRoleDao {

    /**
     * 根据角色编号加载角色信息
     *
     * @param roleId
     * @return
     */
    TblRole selectByRoleId(String roleId);

    /**
     * 根据角色名称加载角色信息
     *
     * @param roleName
     * @return
     */
    TblRole selectByRoleName(String roleName);
}
