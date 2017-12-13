package com.wkb.push;

import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.wkb.push.task.FangcAlarmTask;

public class FchaiAction extends ActionSupport
{
	private int flag;
	private Scheduler scheduler;
	
	@Override
	public String execute() throws Exception
	{
		// TODO Auto-generated method stub
//		Properties config = new Properties();
//		String path = this.getClass().getResource("/com/bcx/push/config.properties").getPath();
		
		if(flag == 1)
		{
			int count = 1;
			if(scheduler == null ||(scheduler != null && !scheduler.isStarted()))
			{
//				System.out.println("start");
//				SchedulerFactory schedFact = PushUtils.getSchedulerFactory();
//		        scheduler = schedFact.getScheduler();
		        StdSchedulerFactory sf = PushUtils.getSchedulerFactory();
				Properties props = new Properties();
				props.put("org.quartz.scheduler.instanceName", "wkbfangc");
				props.put("org.quartz.threadPool.threadCount", "5"); // 必填
				sf.initialize(props);
				scheduler = sf.getScheduler();
//		        Scheduler scheduler2 = schedFact.getScheduler();
//		        System.out.println(scheduler);
//		        System.out.println(scheduler2);
//		        System.out.println(Objects.equals(scheduler, scheduler2));
		        //job1
		        
		        
		        
		        Class<? extends Job> clazz = FangcAlarmTask.class;
		        String runtime = "0/10 * * * * ?";
		        JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity("job"+count, "group"+count).build();
				CronTrigger trigger = TriggerBuilder.newTrigger()
													.withIdentity("trigger"+count, "group"+count)  
													.withSchedule(CronScheduleBuilder.cronSchedule(runtime))
													.build();
//				count++;
//				//job2
//				clazz = ExpireAlarmTask.class;
//				runtime = "0/5 * 11 * * ? ";
//				JobDetail jobDetail2 = JobBuilder.newJob(clazz).withIdentity("job"+count, "group"+count).build();
//				CronTrigger trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger"+count,"group"+count).withSchedule(CronScheduleBuilder.cronSchedule(runtime)).build();
//				count++;
//				
//				//job3
//				clazz = BalanceAlarmTask.class;
//				runtime = "0/5 * 11 * * ? ";
//				JobDetail jobDetail3 = JobBuilder.newJob(clazz).withIdentity("job"+count, "group"+count).build();
//				CronTrigger trigger3 = TriggerBuilder.newTrigger().withIdentity("trigger"+count,"group"+count).withSchedule(CronScheduleBuilder.cronSchedule(runtime)).build();
//				count++;
//				//job4
//				clazz = FenceAlarmTask.class;
//		        runtime = "0/10 * * * * ?";
//		        JobDetail jobDetail4 = JobBuilder.newJob(clazz).withIdentity("job"+count, "group"+count).build();
//				CronTrigger trigger4 = TriggerBuilder.newTrigger()
//													.withIdentity("trigger"+count, "group"+count)  
//													.withSchedule(CronScheduleBuilder.cronSchedule(runtime))
//													.build();
//				count++;
//				
//				//job5
//				clazz = VibrationAlarmTask.class;
//		        runtime = "0/10 * * * * ?";
//		        JobDetail jobDetail5 = JobBuilder.newJob(clazz).withIdentity("job"+count, "group"+count).build();
//				CronTrigger trigger5 = TriggerBuilder.newTrigger()
//													.withIdentity("trigger"+count, "group"+count)  
//													.withSchedule(CronScheduleBuilder.cronSchedule(runtime))
//													.build();
//				count++;
				scheduler.scheduleJob(jobDetail, trigger);
//				scheduler.scheduleJob(jobDetail2, trigger2);
//				scheduler.scheduleJob(jobDetail3, trigger3);
//				scheduler.scheduleJob(jobDetail4, trigger4);
//				scheduler.scheduleJob(jobDetail5, trigger5);
				scheduler.start();
			}
			
		}
		if(flag == 2 )
		{
			if(scheduler != null&& scheduler.isStarted())
			{
//				System.out.println("ele stop");
				scheduler.clear();
				scheduler.shutdown();
				scheduler = null;
			}
		}
		if(flag == 3)
		{
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter writer = response.getWriter();
			
			if(scheduler == null)
			{
				writer.write("stop");
			}
			if(scheduler != null)
			{
				if(scheduler.isStarted())
				{
					writer.write("start");
				}else if(scheduler.isShutdown())
				{
					writer.write("stop");
				}
			}
		}
		
		
//		InputStream in = this.getClass().getResourceAsStream("/com/bcx/push/config.properties");
//		try
//		{
//			config.load(in);
//		}catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}
//		String appKey = config.getProperty("appKey");
//		System.out.println(appKey);
//		String appKey = "ac6d111ac6683b3eb22ff701";
//		String masterSecret = "f02ebffb0c59922b354b594c";

		return null;
	}
	

	public int getFlag()
	{
		return flag;
	}
	public void setFlag(int flag)
	{
		this.flag = flag;
	}
	
}
