package com.bcx.push;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.struts2.ServletActionContext;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.bcx.push.task.OtherTask;
import com.opensymphony.xwork2.ActionSupport;

public class OtherAction extends ActionSupport
{
//	private int flag;
//	private Scheduler scheduler;

	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter writer = response.getWriter();
		final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		String jm = PushUtils.jdkSha1(day+"&"+PushUtils.Salt);
		String path ="http://apiv6.dkwgps.com/Information/advertPush?jm="+jm.toUpperCase();
		JsonObject jsonRes = PushUtils.getInputStreamJson(path);
		ExecutorService executor = PushUtils.getThreadPool();
		try
		{
			String result = jsonRes.get("result").getAsString();
			if ("1".equals(result))
			{
				JsonArray jsonArray = jsonRes.get("datas").getAsJsonArray();
				System.out.println(jsonArray.toString());
				for (JsonElement jsonEle : jsonArray)
				{
					JsonObject jsonObj = jsonEle.getAsJsonObject();
					String loginName = jsonObj.get("loginname").getAsString();
					String content = jsonObj.get("content").getAsString();
					String type = jsonObj.get("type").getAsString();
					final String id = jsonObj.get("id").getAsString();

					PushUtils.pushMessage(loginName, content, type);
					Future<?> future =  executor.submit(new Runnable(){
						@Override
						public void run()
						{
							// TODO Auto-generated method stub
							String jm2 = PushUtils.jdkSha1(id+"&"+PushUtils.Salt);
							String pathback = "http://apiv6.dkwgps.com/Information/upAdvertPush";
//							String param = "id="+id+"&jm="+jm2.toUpperCase();
							JsonObject jsonObj = new JsonObject();
							jsonObj.addProperty("id", id);
							jsonObj.addProperty("jm", jm2.toUpperCase());
							String jsonStr = new Gson().toJson(jsonObj);
							PushUtils.updataAlarm(pathback, jsonStr);
						}
					});

				}
				writer.write("success");
			}else if ("0".equals(result)){
				writer.write("没有数据");
			}else {
				writer.write("失败");
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	/*@Override
	public String execute() throws Exception
	{
		if (flag == 1)
		{
			if (scheduler == null
					|| (scheduler != null && !scheduler.isStarted()))
			{
				int count = 0;
				StdSchedulerFactory sf = PushUtils.getSchedulerFactory();
				Properties props = new Properties();
				props.put("org.quartz.scheduler.instanceName", "bcxexpire");
				props.put("org.quartz.threadPool.threadCount", "5"); // 必填
				sf.initialize(props);
				scheduler = sf.getScheduler();

				Class<? extends Job> clazz = OtherTask.class;
				String runtime = "0/10 * * * * ?";//0 0 09 * * ?
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
				// System.out.println("expire stop");
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
	*/
}
