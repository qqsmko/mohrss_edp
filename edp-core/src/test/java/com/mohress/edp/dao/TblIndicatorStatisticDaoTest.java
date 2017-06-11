package com.mohress.edp.dao;

import com.mohress.edp.model.TblIndicatorStatistics;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by youtao.wan on 2017/6/10.
 */
public class TblIndicatorStatisticDaoTest extends BaseDaoTest {

    @Resource
    private TblIndicatorStatisticsDao dao;

    @Test
    public void testInsert(){
        TblIndicatorStatistics value = new TblIndicatorStatistics();
        value.setIndicatorType("login_fail");
        value.setIndicatorName("youtao.wan");
        value.setCycleTime("1d");
        value.setCycleStatisticsValue(1);
        value.setUpdateTime(new Date());

        dao.insert(value);
    }
}
