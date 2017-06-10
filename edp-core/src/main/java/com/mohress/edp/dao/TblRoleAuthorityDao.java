package com.mohress.edp.dao;


import com.mohress.edp.model.TblRoleAuthority;

import java.util.List;

/**
 * Created by youtao.wan on 2017/6/6.
 */
public interface TblRoleAuthorityDao {

    List<TblRoleAuthority> selectByRoleId(String roleId);
}
