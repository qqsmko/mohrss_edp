package com.mohress.edp.security;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mohress.edp.model.TblAccount;
import com.mohress.edp.model.TblAuthority;
import com.mohress.edp.util.AccountAuthorities;
import com.mohress.edp.util.DateUtil;
import com.mohress.edp.util.RoleAuthorities;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账号信息和账号权限信息加载
 *
 * Created by youtao.wan on 2017/6/6.
 */
public class AccountSecurityService implements UserDetailsService {

    @Resource
    private AccountAuthorityCache cache;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(userName), "登录账号名为空");

        AccountAuthorities accountAuthorities = cache.getIfPresent(userName);
        if (accountAuthorities == null){
            throw new UsernameNotFoundException(userName + "不存在");
        }

        List<GrantedAuthority> authorities = loadAuthorities(accountAuthorities);

        TblAccount account = accountAuthorities.getAccount();

        // 是否过期
        boolean isExpired = account.isExpired() || DateUtil.isBeforeNow(account.getDeadLine());

        UserDetails userDetails = new User(account.getAccount(),
                account.getPassword(),
                account.isEnable(),
                isExpired,
                true,
                account.isLocked(),
                authorities);
        return userDetails;
    }

    /**
     * 加载用户的所有权限
     *
     * @param accountAuthorities
     * @return
     */
    private List<GrantedAuthority> loadAuthorities(AccountAuthorities accountAuthorities){
        List<RoleAuthorities> roleAuthoritiesList = accountAuthorities.getRoleAuthorities();
        if (CollectionUtils.isEmpty(roleAuthoritiesList)){
            return ImmutableList.of();
        }

        List<GrantedAuthority> authorityList = Lists.newArrayList();
        for (RoleAuthorities it: roleAuthoritiesList){
            if (CollectionUtils.isEmpty(it.getAuthorities())){
                continue;
            }

            for (TblAuthority authority : it.getAuthorities()){
                authorityList.add(new SimpleGrantedAuthority(authority.getAuthorityName()));
            }
        }

        return authorityList;
    }
}
