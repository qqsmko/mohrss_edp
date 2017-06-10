package com.mohress.edp.security.listener;

import com.mohress.edp.dao.TblAccountDao;
import com.mohress.edp.util.DateUtil;
import com.mohress.edp.util.MonitorLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

import static com.mohress.edp.util.MonitorNames.*;

/**
 * 账号登录成功监听器
 * 修改登录时间,登录Ip
 *
 * Created by youtao.wan on 2017/6/8.
 */
@Component
public class LoginSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private static final Logger log = LoggerFactory.getLogger(LoginSuccessEventListener.class);

    @Resource
    private TblAccountDao accountDao;

    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent){
        // 此处的类型转化需要看源码
        Authentication authentication = authenticationSuccessEvent.getAuthentication();
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
        WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails)token.getDetails();

        String loginIp = webAuthenticationDetails.getRemoteAddress();
        String userName = authentication.getName();
        Date loginTime = new Date();

        //更新登录时间和登录IP
        accountDao.updateLoginInfo(userName, loginIp, loginTime);

        String timeStamp = DateUtil.toString(loginTime, "yyyyMMddHHmmss");
        MonitorLog.info(log, BUSI_SECURITY, PROCESS_LOGIN, NODE_AUTHENTICATION, EVENT_AUTHENTICATION_SUCCESS, String.format("loginAccount【%s】, loginIp【%s】在%s登录成功，", userName, loginIp, timeStamp), timeStamp);
    }
}
