package com.mohress.edp.dao;


import com.mohress.edp.model.TblAuthority;

/**
 * Created by youtao.wan on 2017/6/6.
 */
public interface TblAuthorityDao {

    TblAuthority selectByAuthorityId(String authorityId);

    TblAuthority selectByAuthorityName(String authorityName);
}
