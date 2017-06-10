package com.mohress.edp.dao;

import com.mohress.edp.model.TblAccount;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by youtao.wan on 2017/6/6.
 */
public interface TblAccountDao {

    /**
     * 根据用户名加载账号信息
     * @param userName
     * @return
     */
    TblAccount selectByUserName(String userName);


    /**
     * 更新账号的登录信息
     *
     * @param userName
     * @param loginIp
     * @param loginTime
     * @return
     */
    int updateLoginInfo(@Param("userName") String userName, @Param("loginIp") String loginIp, @Param("loginTime") Date loginTime);
    /**
     * 更新账号锁定状态
     *
     * @param userName
     * @param isLocked
     * @return
     */
    int updateLockedStatus(@Param("userName") String userName, @Param("isLocked") boolean isLocked);

    /**
     * 更新账号可用状态
     *
     * @param userName
     * @param enable
     * @return
     */
    int updateEnableStatus(@Param("userName") String userName, @Param("enable") boolean enable);

    /**
     * 更新账号过期状态
     *
     * @param userName
     * @param isExpired
     * @return
     */
    int updateExpiredStatus(@Param("userName") String userName, @Param("isExpired") boolean isExpired);
}
