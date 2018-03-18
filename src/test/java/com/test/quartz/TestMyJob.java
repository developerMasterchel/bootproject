/**
 * 文件名    ： TestMyJob.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年6月11日
 * 修改内容：<修改内容>
 */
package com.test.quartz;

import com.commons.myquartz.MyQuartzUtils;
import com.commons.myquartz.job.MyJobDemo;

public class TestMyJob {
	
	public static void main(String[] args) {
		MyJobDemo mj = new MyJobDemo();
		mj.setJobName("testMQ");
		mj.setLogPath("/home/log");
		mj.setPath("/log");
		MyQuartzUtils.add(mj);
	}

}
