package com.mohress.edp.model;


import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
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
        Date nextCycleTime = CycleTimeParser.nextCycleTime(this);
        return DateUtil.isAfterNow(nextCycleTime);
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

    private static final class CycleTimeParser{
        private static final ImmutableMap.Builder<String, CycleTimeParserEnum> builder = ImmutableMap.builder();

        private static final ImmutableMap<String, CycleTimeParserEnum> parserMap = builder
                .put("y", CycleTimeParserEnum.Year)
                .put("M", CycleTimeParserEnum.Month)
                .put("d", CycleTimeParserEnum.Day)
                .put("h", CycleTimeParserEnum.Hour)
                .put("m", CycleTimeParserEnum.Minute)
                .put("s", CycleTimeParserEnum.Second)
                .build();

        public static Date nextCycleTime(TblIndicatorStatistics indicatorStatistics){
            String cycleTime = indicatorStatistics.getCycleTime();
            String cycleTimeType = cycleTime.substring(cycleTime.length()-1);
            CycleTimeParserEnum parser = parserMap.get(cycleTimeType);
            Preconditions.checkNotNull(parser, cycleTime+"不合法");

            parser.parse(indicatorStatistics);
            return parser.nextCycleTime();
        }

    }

    private enum CycleTimeParserEnum {

        Year{
            @Override
            public Date nextCycleTime() {
                return DateUtil.addYear(previousCycleTime, cycleTimeValue);
            }
        },

        Month{
            @Override
            public Date nextCycleTime() {
                return DateUtil.addMonth(previousCycleTime, cycleTimeValue);
            }
        },

        Day{
            public Date nextCycleTime(){
                return DateUtil.addDay(previousCycleTime, cycleTimeValue);
            }
        },

        Hour{
            @Override
            public Date nextCycleTime() {
                return DateUtil.addHour(previousCycleTime, cycleTimeValue);
            }
        },

        Minute{
            @Override
            public Date nextCycleTime() {
                return DateUtil.addMinute(previousCycleTime, cycleTimeValue);
            }
        },

        Second{
            @Override
            public Date nextCycleTime() {
                return DateUtil.addSecond(previousCycleTime, cycleTimeValue);
            }
        }
        ;

        int cycleTimeValue;

        Date previousCycleTime;

        public void parse(TblIndicatorStatistics tblIndicatorStatistics) {
            String cycleTime = tblIndicatorStatistics.getCycleTime();
            String s = cycleTime.substring(0, cycleTime.length() -1);
            cycleTimeValue = Integer.valueOf(s);
            previousCycleTime = tblIndicatorStatistics.getUpdateTime();
        }

        public abstract Date nextCycleTime();
    }
}
