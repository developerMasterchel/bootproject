/**
 * 文件名    ： MyQuartzUtils.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年6月5日
 * 修改内容：<修改内容>
 */
package com.commons.myquartz;

import java.text.ParseException;
import java.util.Calendar;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.commons.myquartz.job.MyAbstractJob;
import com.commons.myquartz.job.ScheduleType;

public class MyQuartzUtils {
	
	private static Scheduler init(){
		  SchedulerFactory schedFact=new StdSchedulerFactory();
		try {
			Scheduler sched = schedFact.getScheduler();
			sched.start();
			return sched;
		} catch (SchedulerException e) {
			return null;
		}
	}
	
	public static void delete (MyAbstractJob job){
		try {
			Scheduler sched = init();
			sched.deleteJob(job.getJobName(),job.getGroupName());
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public static void add(MyAbstractJob job){
		Scheduler sched = init();
		JobDetail jobDetail=new JobDetail(job.getJobName(),job.getGroupName(),job.getClass());
		// 放入 名称 job  的 data map
        jobDetail.getJobDataMap().put("job",job);
        
        CronTrigger trigger=new  CronTrigger(job.getJobName(),job.getGroupName());
        try {
			trigger.setCronExpression(getCron(job));
			// 加入任务
			sched.scheduleJob(jobDetail, trigger);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SchedulerException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * <一句话功能简述> 产生 任务 启动时间规则
	 * <功能详细描述>
	 * @param job
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private static String getCron(MyAbstractJob job){
		Calendar cal = Calendar.getInstance();
		String sec = String.valueOf(cal.get(Calendar.SECOND));
		String min = String.valueOf(cal.get(Calendar.MINUTE));
		//默认 每分钟一次
//		 "0 * * * * ? ";
		switch (job.getCronType()) {
			case ScheduleType.CUSTOM:
				String defaultCron = job.getCron();
				if(null !=  defaultCron&& !"".equals(defaultCron))
					return defaultCron;
				else {
					return "0 * * * * ? ";
				}
				
			case ScheduleType.HOUR:
				return createCron(sec,min,"*","*","*","?");
					
			case ScheduleType.DAILY:
				return createCron(sec,min,String.valueOf(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH)),"*","*","?");
//					return "0 0 0 * * ? ";
					
			case ScheduleType.WEEK:
				return createCron(sec,min,String.valueOf(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH)),"?","*",getWeek(cal.get(Calendar.DAY_OF_WEEK)));
//				return "0 0 0 ? *  WED";
				
			default:
				return "0 * * * * ? ";
		}
	}
	
	/** 
	 * <一句话功能简述> 产生cron
	 * <功能详细描述>
	 * @param sec
	 * @param min
	 * @param hour
	 * @param day
	 * @param mouth
	 * @param week
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private static String createCron(String sec,String min, String hour, String day, String mouth, String week){
		StringBuilder sb = new StringBuilder();
		sb.append(sec).append(" ").append(min+1).append(" ").append(hour).append(" ")
			.append(day).append(" ").append(mouth).append(" ").append(week);
		return sb.toString();
	}

	private static String getWeek(int dayOfWeek){
		String day = "Mon";
		switch (dayOfWeek) {
			case Calendar.TUESDAY:
				day = "TUE";
				break;
				
			case Calendar.WEDNESDAY:
				day = "WED";
				break;
				
			case Calendar.THURSDAY:
				day = "THU";
				break;
				
			case Calendar.FRIDAY:
				day = "FRI";
				break;
				
			case Calendar.SATURDAY:
				day = "SAT";
				break;
				
			case Calendar.SUNDAY:
				day = "SUN";
				break;

			default:
				break;
		}
		return day;
	}
}
