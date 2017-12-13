package com.nd.push;

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
import com.nd.push.task.ChargeAlarmTask;

public class ChargeAction extends ActionSupport
{
	private int flag;
	private Scheduler scheduler;

	@Override
	public String execute() throws Exception
	{
		// TODO Auto-generated method stub
		if (flag == 1)
		{
			int count = 0;
			if (scheduler == null
					|| (scheduler != null && !scheduler.isStarted()))
			{
				StdSchedulerFactory sf = PushUtils.getSchedulerFactory();
				Properties props = new Properties();
				props.put("org.quartz.scheduler.instanceName", "ndcharge");
				props.put("org.quartz.threadPool.threadCount", "5"); // 必填
				sf.initialize(props);
				scheduler = sf.getScheduler();

				// System.out.println(scheduler.getSchedulerName());
				// scheduler.shutdown();
				// scheduler = new StdSchedulerFactory().getScheduler();
				Class<? extends Job> clazz = ChargeAlarmTask.class;
				String runtime = "0/10 * * * * ?";
				JobDetail jobDetail = JobBuilder.newJob(clazz)
						.withIdentity("job" + count, "group" + count).build();
				CronTrigger trigger = TriggerBuilder
						.newTrigger()
						.withIdentity("trigger" + count, "group" + count)
						.withSchedule(CronScheduleBuilder.cronSchedule(runtime))
						.build();
				count++;
				scheduler.scheduleJob(jobDetail, trigger);

				scheduler.start();
			}
		}
		if (flag == 2)
		{
			if (scheduler != null && scheduler.isStarted())
			{
				// System.out.println("fence stop");
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
