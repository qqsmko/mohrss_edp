package com.mohress.edp.util;

import com.mohress.edp.model.TblAuthority;
import com.mohress.edp.model.TblRole;

import java.util.List;

/**
 * 角色权限
 *
 * Created by youtao.wan on 2017/6/7.
 */
public class RoleAuthorities {

    private TblRole role;

    private List<TblAuthority> authorities;

    public RoleAuthorities(TblRole role, List<TblAuthority> authorities) {
        this.role = role;
        this.authorities = authorities;
    }

    public TblRole getRole() {
        return role;
    }

    public List<TblAuthority> getAuthorities() {
        return authorities;
    }
}
