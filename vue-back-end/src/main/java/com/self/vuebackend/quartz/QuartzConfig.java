package com.self.vuebackend.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz配置类
 */
@Configuration
public class QuartzConfig {

    /**
     * 配置测试定时任务
     * @return JobDetail
     */
    @Bean
    public JobDetail testQuartzDetail(){
        return JobBuilder.newJob(TestQuartz.class).withIdentity("testQuartz").storeDurably().build();
    }

    /**
     * 配置测试定时任务
     * @return Trigger
     */
    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(30)  //设置定时任务间隔，单位为秒
                .repeatForever();

        return TriggerBuilder.newTrigger().forJob(testQuartzDetail())
                .withIdentity("testQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }

    /*===============================================================================*/

}
