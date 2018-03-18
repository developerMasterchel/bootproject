/**
 * 文件名    ： MyJob.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年6月5日
 * 修改内容：<修改内容>
 */
package com.commons.myquartz.job;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJobDemo extends MyAbstractJob {
	
	private String path;
	
	private String logPath;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLogPath() {
		return logPath;
	}

	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("name:" + getJobName() + ",  path:"+ path + ",  logPath:"+logPath +"    -- " + new Date());
		//拿去 名称 job  的 data map
		MyJobDemo job = (MyJobDemo) context.getJobDetail().getJobDataMap().get("job");
		System.out.println("2name:" + job.getJobName() + ",  2path:"+ job.getPath() + ",  2logPath:"+ job.getLogPath() +"    -- " + new Date());
	}

}
