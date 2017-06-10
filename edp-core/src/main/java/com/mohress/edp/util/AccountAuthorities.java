package com.mohress.edp.util;

import com.mohress.edp.model.TblAccount;

import java.util.List;

/**
 * 账户权限包装实体
 * 目前为止一个账号仅对应一个角色，一个账号对应多个角色，以后扩展，目前暂不考虑
 *
 * Created by youtao.wan on 2017/6/6.
 */
public class AccountAuthorities {

    private TblAccount account;

    private List<RoleAuthorities> roleAuthorities;

    public AccountAuthorities(TblAccount account, List<RoleAuthorities> roleAuthorities) {
        this.account = account;
        this.roleAuthorities = roleAuthorities;
    }

    public TblAccount getAccount() {
        return account;
    }

    public List<RoleAuthorities> getRoleAuthorities() {
        return roleAuthorities;
    }
}

