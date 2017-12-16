package com.bcx.push;

import com.bcx.push.task.OtherTask;
import com.bcx.push.task.RunTask;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * 行驶提醒
 */

public class RunAction extends ActionSupport {

    private int flag;
    private Scheduler scheduler;

    @Override
    public String execute() throws Exception {
        System.out.println("flag:"+flag);
        if (flag == 0)
        {
            if (scheduler == null
                    || (scheduler != null && !scheduler.isStarted()))
            {
                int count = 0;
                StdSchedulerFactory sf = PushUtils.getSchedulerFactory();
                Properties props = new Properties();
                props.put("org.quartz.scheduler.instanceName", "bcxrun");
                props.put("org.quartz.threadPool.threadCount", "5"); // 必填
                sf.initialize(props);
                scheduler = sf.getScheduler();

                Class<? extends Job> clazz = RunTask.class;
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

    public void closePush(){
        try {
            if (scheduler != null && scheduler.isStarted())
            {
                // System.out.println("fence stop");
                scheduler.clear();
                scheduler.shutdown();
                scheduler = null;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}