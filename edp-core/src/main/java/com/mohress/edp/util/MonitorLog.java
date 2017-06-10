package com.mohress.edp.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

/**
 * 1.监控日志
 * 2.规范日志格式，便于日志分析
 *
 * Created by youtao.wan on 2017/6/9.
 */
public final class MonitorLog {

    /**
     * @param logger
     * @param busi    业务
     * @param process 流程
     * @param node    结点
     * @param event   事件
     * @param desc    描述
     */
    public static void error(Logger logger, String busi, String process, String node, String event, String desc){
        try{
            String content = String.format("busi=%s, process=%s, node=%s, event=%s, desc=%s", empty(busi), empty(process), empty(node), empty(event), empty(desc));
            logger.error(content);
        }catch(Throwable e){
            logger.error("", e);
        }
    }

    /**
     * @param logger
     * @param busi    业务
     * @param process 流程
     * @param node    结点
     * @param event   事件
     * @param desc    描述
     * @param e       异常
     */
    public static void error(Logger logger, String busi, String process, String node, String event, String desc, Throwable e){
        try{
            String content = String.format("busi=%s, process=%s, node=%s, event=%s, desc=%s", empty(busi), empty(process), empty(node), empty(event), empty(desc));
            logger.error(content, e);//// TODO: 16-10-10 为什么不直接打印在log，而在format一次？
        }catch(Throwable t){
            logger.error("", t);
        }
    }

    /**
     * @param logger
     * @param busi    业务
     * @param process 流程
     * @param node    结点
     * @param event   事件
     * @param desc    描述
     * @param id      编号
     * @param tags    标签
     */
    public static void error(Logger logger, String busi, String process, String node, String event, String desc, String id, String...tags){
        try{
            String content = buildContent(busi, process, node, event, desc, id, tags);
            logger.error(content);
        }catch(Throwable e){
            logger.error("", e);
        }
    }

    /**
     * @param logger
     * @param busi    业务
     * @param process 流程
     * @param node    结点
     * @param event   事件
     * @param desc    描述
     * @param id      编号
     * @param tags    标签
     * @param e       异常
     */
    public static void error(Logger logger, String busi, String process, String node, String event, String desc, String id, Throwable e, String...tags){
        try{
            String content = buildContent(busi, process, node, event, desc, id, tags);
            logger.error(content, e);
        }catch(Throwable t){
            logger.error("", e);
        }
    }

    /**
     * @param logger
     * @param busi    业务
     * @param process 流程
     * @param node    结点
     * @param event   事件
     * @param desc    描述
     * @param id      编号
     * @param tags    标签
     */
    public static void info(Logger logger, String busi, String process, String node, String event, String desc, String id, String...tags){
        try{
            String content = buildContent(busi, process, node, event, desc, id, tags);
            logger.info(content);
        }catch(Throwable t){
            logger.error("", t);
        }
    }

    private static String buildContent(String busi, String process, String node, String event, String desc, String id, String...tags){
        return String.format("busi=%s, process=%s, node=%s, event=%s, desc=%s, id=%s, tags=%s", empty(busi), empty(process), empty(node), empty(event), empty(desc), empty(id), tag(tags));
    }

    private static String tag(String...tags){
        if(tags != null && tags.length > 0){
            StringBuffer allTag = new StringBuffer();
            for(int i = 0; i < tags.length; i++){
                allTag.append("tag" + i).append("=").append(tags[i]);
            }
            return allTag.toString();
        }
        return "";
    }

    private static String empty(String s){
        return StringUtils.defaultIfEmpty(s, "");
    }


}
