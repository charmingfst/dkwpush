package com.processor;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;


/**
 * Created by charming on 2017/12/16.
 * 服务器重启时自动开启推送
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (s.contains("action")&&!s.equals("switchaction")&&s.length()<15)
        {
            if (!s.equals("loginaction")) {
                try {
//                    Class<?> clazz = o.getClass();
//                    Method setFlag = clazz.getMethod("setFlag", int.class);
//                    setFlag.invoke(o, 10);
                    ((ActionSupport) o).execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if ((s.contains("nd")||s.contains("wkb"))&&s.length()<15)
        {

            try {
                ((ActionSupport) o).execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return o;
    }
}
