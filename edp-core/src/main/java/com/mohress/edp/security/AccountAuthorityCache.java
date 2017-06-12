package com.mohress.edp.security;

import com.google.common.base.Supplier;
import com.google.common.cache.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mohress.edp.dao.*;
import com.mohress.edp.model.*;
import com.mohress.edp.util.AccountAuthorities;
import com.mohress.edp.util.MonitorLog;
import com.mohress.edp.util.RoleAuthorities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.mohress.edp.util.MonitorNames.*;


/**
 * 账户权限缓存
 *
 * Created by youtao.wan on 2017/6/6.
 */
@Component
public class AccountAuthorityCache extends ForwardingLoadingCache<String, AccountAuthorities> {

    private static final Logger log = LoggerFactory.getLogger(AccountAuthorityCache.class);

    @Resource
    private TblAccountDao accountDao;

    @Resource
    private TblRoleDao roleDao;

    @Resource
    private TblAuthorityDao authorityDao;

    @Resource
    private TblUserRoleDao userRoleDao;

    @Resource
    private TblRoleAuthorityDao roleAuthorityDao;

    private LoadingCache<String, AccountAuthorities> singleCache;

    public AccountAuthorityCache() {
        singleCache = new SingleCache().get();
    }

    public AccountAuthorityCache(LoadingCache<String, AccountAuthorities> singleCache) {
        this.singleCache = singleCache;
    }

    @Override
    protected LoadingCache<String, AccountAuthorities> delegate() {
        return singleCache;
    }

    /**
     * 从db中加载用户的权限信息
     *
     * @param userName
     * @return
     */
    private AccountAuthorities loadAccountAuthorities(String userName){
        TblAccount account = accountDao.selectByUserName(userName);
        if (account == null || !account.isEnable()){
            MonitorLog.error(log, BUSI_SECURITY, PROCESS_CACHE, NODE_LOADING, EVENT_LOAD_FAIL, String.format("Account【%s】不存在或不可用", userName), userName);
            return null;
        }

        List<TblUserRole> userRoleList = userRoleDao.selectByUserId(account.getUserId());
        if (CollectionUtils.isEmpty(userRoleList)){
            return new AccountAuthorities(account, ImmutableList.<RoleAuthorities>of());
        }

        List<RoleAuthorities> roleAuthoritiesList = Lists.newArrayListWithExpectedSize(userRoleList.size());
        for (TblUserRole it: userRoleList){
            RoleAuthorities roleAuthorities = loadRoleAuthorities(it.getRoleId());
            if (roleAuthorities != null){
                roleAuthoritiesList.add(roleAuthorities);
            }
        }

        return new AccountAuthorities(account, roleAuthoritiesList);
    }

    /**
     * 从db中加载角色的权限信息
     *
     * @param roleId
     * @return
     */
    private RoleAuthorities loadRoleAuthorities(String roleId){
        TblRole role = roleDao.selectByRoleId(roleId);
        if (role == null || !role.isEnable()){
            MonitorLog.info(log, BUSI_SECURITY, PROCESS_CACHE, NODE_LOADING, EVENT_LOAD_FAIL, String.format("Role【%s】不存在或不可用", roleId), roleId);
            return null;
        }

        List<TblRoleAuthority> roleAuthorityList = roleAuthorityDao.selectByRoleId(roleId);
        if (CollectionUtils.isEmpty(roleAuthorityList)){
            return new RoleAuthorities(role, ImmutableList.<TblAuthority>of());
        }

        List<TblAuthority> authorityList = Lists.newArrayListWithExpectedSize(roleAuthorityList.size());
        for (TblRoleAuthority it: roleAuthorityList){
            TblAuthority authority = authorityDao.selectByAuthorityId(it.getAuthorityId());
            if (authority != null && authority.isEnable()){
                authorityList.add(authority);
            }
        }
        return new RoleAuthorities(role, authorityList);
    }

    class SingleCache implements Supplier<LoadingCache<String, AccountAuthorities>> {

        private LoadingCache<String, AccountAuthorities> cache = CacheBuilder.newBuilder()
                .maximumSize(1000).expireAfterAccess(30, TimeUnit.MINUTES)
                .build(new CacheLoader<String, AccountAuthorities>() {
                    @Override
                    public AccountAuthorities load(String s) throws Exception {
                        return loadAccountAuthorities(s);
                    }
                });

        @Override
        public LoadingCache<String, AccountAuthorities> get() {
            return cache;
        }
    }
}
