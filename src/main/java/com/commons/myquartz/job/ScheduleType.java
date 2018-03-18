/**
 * 文件名    ： ScheduleType.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年6月5日
 * 修改内容：<修改内容>
 */
package com.commons.myquartz.job;

/**
 * <一句话功能简述> 任务的 cron 规则，任务频率
 * <功能详细描述>
 * @author    Administrator
 * @version   [版本号，2017年6月5日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public final class ScheduleType{
	
	/** 自定义任务  */
	public final static int CUSTOM = 0;
	
	/** 每时 */
	public final static int HOUR = 1;
	
	/** 每天 */
	public final static int DAILY = 2;
	
	/** 每周  */
	public final static int WEEK = 3;
}
