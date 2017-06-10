package com.mohress.edp.util;

/**
 * Created by youtao.wan on 2017/6/9.
 */
public class MonitorNames {
    /**********************************BUSINESS**********************************/
    /**
     * 安全业务
     */
    public static final String BUSI_SECURITY = "security";

    /**********************************PROCESS**********************************/
    /**
     * 登录流程
     */
    public static final String PROCESS_LOGIN = "login";
    /**
     * 资源访问流程
     */
    public static final String PROCESS_ACCESS = "accessResources";
    /**
     * 数据缓存流程
     */
    public static final String PROCESS_CACHE = "cache";

    /**********************************NODE**********************************/
    /**
     * 验证节点
     */
    public static final String NODE_AUTHENTICATION = "authentication";
    /**
     * 授权节点
     */
    public static final String NODE_AUTHORIZATION = "authorization";
    /**
     * 数据加载节点
     */
    public static final String NODE_LOADING = "load";

    /**********************************EVENT**********************************/
    /**
     * 验证失败事件
     */
    public static final String EVENT_AUTHENTICATION_FAIL = "authenticationFail";
    /**
     * 验证成功事件
     */
    public static final String EVENT_AUTHENTICATION_SUCCESS = "authenticationSuccess";
    /**
     * 授权失败事件
     */
    public static final String EVENT_AUTHORIZATION_FAIL = "authorizationFail";
    /**
     * 授权成功事件
     */
    public static final String EVENT_AUTHORIZATION_SUCCESS = "authorization_success";
    /**
     * 数据加载失败(数据不存在)
     */
    public static final String EVENT_LOAD_FAIL = "load_fail";
}
