package com.self.vuebackend.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 测试定时任务
 */
public class TestQuartz extends QuartzJobBean {

    /**
     * 执行定时任务
     * @param jobExecutionContext jobExecutionContext
     * @throws JobExecutionException JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz task " + new Date());
    }

}
