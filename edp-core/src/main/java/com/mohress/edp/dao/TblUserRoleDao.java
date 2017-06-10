package com.mohress.edp.dao;


import com.mohress.edp.model.TblUserRole;

import java.util.List;

/**
 * Created by youtao.wan on 2017/6/6.
 */
public interface TblUserRoleDao {

    List<TblUserRole> selectByUserId(String userId);
}
