package com.mohress.edp.security;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.*;
import java.io.IOException;

/**
 * 资源访问安全拦截器，用于校验用户权限
 *
 *
 * Created by youtao.wan on 2017/6/7.
 */
public class ResourceAccessSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    private FilterInvocationSecurityMetadataSource resourceAuthorityPreloadingService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        FilterInvocation invocation = new FilterInvocation(servletRequest, servletResponse, filterChain);

        // 资源访问的权限校验
        InterceptorStatusToken token = super.beforeInvocation(invocation);

        try {
            invocation.getChain().doFilter(invocation.getRequest(), invocation.getResponse());
            super.afterInvocation(token, null);
        }finally {
            super.finallyInvocation(token);
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public Class<?> getSecureObjectClass() {
        return UsernamePasswordAuthenticationToken.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return resourceAuthorityPreloadingService;
    }

    public void setResourceAuthorityPreloadingService(FilterInvocationSecurityMetadataSource resourceAuthorityPreloadingService) {
        this.resourceAuthorityPreloadingService = resourceAuthorityPreloadingService;
    }
}
