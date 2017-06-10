package com.mohress.edp.security;

import com.google.common.collect.Sets;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * 预加载所有资源及其访问该资源所需要的权限
 * <p>
 * Created by youtao.wan on 2017/6/6.
 */
public class ResourceAuthorityPreloadingService implements FilterInvocationSecurityMetadataSource {

    @Resource
    private ResourceAuthorityCache cache;

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        String url = ((FilterInvocation) o).getRequestUrl();
        int index = url.indexOf("?");
        if (index != -1) {
            url = url.substring(0, index);
        }

        Set<ConfigAttribute> configAttributes = Sets.newHashSet();

        Set<String> allResource = cache.getAllResource();
        for (String path : allResource) {
            if (pathMatcher.match(path, url)) {
                configAttributes.addAll(cache.getAuthorities(path));
            }
        }
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> configAttributes = Sets.newHashSet();

        Set<String> allResource = cache.getAllResource();
        for (String path : allResource) {
            configAttributes.addAll(cache.getAuthorities(path));
        }
        return configAttributes;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(Authentication.class);
    }
}
