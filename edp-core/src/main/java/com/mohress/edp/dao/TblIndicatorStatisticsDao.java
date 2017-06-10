package com.mohress.edp.dao;

import com.mohress.edp.model.TblIndicatorStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by youtao.wan on 2017/6/8.
 */
public interface TblIndicatorStatisticsDao {

    /**
     * 根据指标类型和指标名查询指标统计信息
     *
     * @param indicatorType
     * @param indicatorName
     * @return
     */
    TblIndicatorStatistics selectByTypeAndName(@Param("indicatorType") String indicatorType, @Param("indicatorName") String indicatorName);

    /**
     * 插入指标信息
     *
     * @param indicatorStatistics
     * @return
     */
    int insert(TblIndicatorStatistics indicatorStatistics);

    /**
     * 更新指标周期统计值
     *
     * @param indicatorType
     * @param indicatorName
     * @param newStatisticsValue
     * @return
     */
    int updateCycleStatisticsValue(@Param("indicatorType") String indicatorType, @Param("indicatorName") String indicatorName, @Param("newStatisticsValue") int newStatisticsValue);

    /**
     * 更新指标周期统计值
     *
     * @param indicatorType
     * @param indicatorName
     * @param newStatisticsValue
     * @return
     */
    int updateCycleStatisticsValueAndTime(@Param("indicatorType") String indicatorType, @Param("indicatorName") String indicatorName, @Param("newStatisticsValue") int newStatisticsValue, @Param("updateTime") Date updateTime);
}
