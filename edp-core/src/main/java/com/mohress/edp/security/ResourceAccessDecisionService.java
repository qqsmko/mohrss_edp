package com.mohress.edp.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * 验证用户访问资源权限
 *
 * Created by youtao.wan on 2017/6/7.
 */
public class ResourceAccessDecisionService implements AccessDecisionManager {

    private AccessDecisionVoter<Object> voter;

    public ResourceAccessDecisionService(AccessDecisionVoter voter) {
        this.voter = voter;
    }

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        // 访问该资源不需要任何的权限，直接放行
        if (CollectionUtils.isEmpty(collection)){
            return;
        }

        // 决策用户是否具有访问该资源的权限
        if (1==voter.vote(authentication, o, collection)){
            return;
        }

        throw new AccessDeniedException("用户无权限");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(Authentication.class);
    }
}
