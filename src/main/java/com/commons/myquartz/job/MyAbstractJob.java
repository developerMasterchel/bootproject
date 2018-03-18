/**
 * 文件名    ： MyJob.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年6月4日
 * 修改内容：<修改内容>
 */
package com.commons.myquartz.job;

import org.quartz.Job;

/**
 * <一句话功能简述> 抽象 任务类
 * <功能详细描述> 为quartz 灵活调用创建的 自定义 任务类
 * @author    Administrator
 * @version   [版本号，2017年6月5日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public abstract class MyAbstractJob implements Job{
	
	private String jobName;
	
	private String groupName;
	
	private int cronType;
	
	private String cron;
	
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getCronType() {
		return cronType;
	}

	public void setCronType(int cronType) {
		this.cronType = cronType;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

}
