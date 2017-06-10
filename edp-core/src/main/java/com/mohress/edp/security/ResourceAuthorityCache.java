package com.mohress.edp.security;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;
import com.mohress.edp.dao.TblAccessResourceDao;
import com.mohress.edp.dao.TblAuthorityDao;
import com.mohress.edp.dao.TblAuthorityResourceDao;
import com.mohress.edp.model.TblAccessResource;
import com.mohress.edp.model.TblAuthority;
import com.mohress.edp.model.TblAuthorityResource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;


/**
 * 资源权限缓存
 *
 * Created by youtao.wan on 2017/6/6.
 */
@Component
public class ResourceAuthorityCache{

    @Resource
    private TblAuthorityDao authorityDao;

    @Resource
    private TblAccessResourceDao accessResourceDao;

    @Resource
    private TblAuthorityResourceDao authorityResourceDao;

    private SetMultimap<String, ConfigAttribute> map = HashMultimap.create();

    @PostConstruct
    public void init(){
        List<TblAccessResource> allAuthorities = accessResourceDao.selectAll();
        if (CollectionUtils.isEmpty(allAuthorities)){
            return;
        }

        for (TblAccessResource resource: allAuthorities){
            List<TblAuthorityResource> authorityResourceList = authorityResourceDao.selectByResourceId(resource.getResourceId());
            if (CollectionUtils.isEmpty(authorityResourceList)){
                continue;
            }
            for (TblAuthorityResource it: authorityResourceList){
                TblAuthority authority = authorityDao.selectByAuthorityId(it.getAuthorityId());
                if (authority != null && authority.isEnable()){
                    map.put(resource.getResourcePath(), new SecurityConfig(authority.getAuthorityName()));
                }
            }
        }
    }

    public Set<String> getAllResource(){
        return map.keySet();
    }

    public Set<ConfigAttribute> getAuthorities(String url){
        return map.get(url);
    }
}
