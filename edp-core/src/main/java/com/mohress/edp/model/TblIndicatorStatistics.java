package com.mohress.edp.model;


import com.mohress.edp.util.DateUtil;

import java.util.Date;

/**
 * 周期指标统计
 *
 * Created by youtao.wan on 2017/6/8.
 */
public class TblIndicatorStatistics {
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 指标类型
     * (Account, Authority等)
     */
    private String indicatorType;
    /**
     * 指标名
     * (userName, authorityId等)
     */
    private String indicatorName;
    /**
     * 时间周期(1s, 1m, 1d, 1w，1M, 1y)
     */
    private String cycleTime;
    /**
     * 周期内指标统计值
     */
    private Integer cycleStatisticsValue;
    /**
     * 指标值更新时间
     */
    private Date updateTime;

    public boolean isCycle(){
        // TODO 计算下一个周期时间
        Date date = new Date();
        return DateUtil.isAfterNow(date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndicatorType() {
        return indicatorType;
    }

    public void setIndicatorType(String indicatorType) {
        this.indicatorType = indicatorType;
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public String getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(String cycleTime) {
        this.cycleTime = cycleTime;
    }

    public Integer getCycleStatisticsValue() {
        return cycleStatisticsValue;
    }

    public void setCycleStatisticsValue(Integer cycleStatisticsValue) {
        this.cycleStatisticsValue = cycleStatisticsValue;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TblIndicatorStatistics{" +
                "id=" + id +
                ", indicatorType='" + indicatorType + '\'' +
                ", indicatorName='" + indicatorName + '\'' +
                ", cycleTime='" + cycleTime + '\'' +
                ", cycleStatisticsValue='" + cycleStatisticsValue + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
