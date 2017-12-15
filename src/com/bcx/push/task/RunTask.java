package com.bcx.push.task;

import com.bcx.push.PushUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by charming on 2017/12/15.
 */
public class RunTask implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        String jm = PushUtils.jdkSha1(day + "&" + PushUtils.Salt);
        String path = "http://apiv6.dkwgps.com/Information/remindXS?jm=" + jm.toUpperCase();
        JsonObject jsonRes = PushUtils.getInputStreamJson(path);
        ExecutorService executor = PushUtils.getThreadPool();
        try {

            PushUtils.remindAll(jsonRes);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
