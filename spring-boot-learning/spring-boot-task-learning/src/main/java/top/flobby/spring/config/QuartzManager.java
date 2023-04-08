package top.flobby.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : quartz管理工具类
 * @create : 2023-04-08 10:54
 **/

@Slf4j
@Component
public class QuartzManager {
    //调度工厂
    @Autowired
    private SchedulerFactoryBean schedulerFactory;

    public Scheduler getScheduled() throws SchedulerException {

        return schedulerFactory.getScheduler();
    }

    /**
     * 添加定时任务
     * @param jobGroupName job任务分组名称
     * @param triggerGroupName job触发器分组名称
     * @param jobName 任务名称
     * @param jobClazz 任务job
     * @param cron 执行时间之cron表达式
     * @param params 任务job参数
     */
    public void addJob(String jobGroupName, String triggerGroupName, String jobName , Class jobClazz ,
                       String cron, Map<String,String> params) throws SchedulerException {
        //获取Scheduler
        Scheduler scheduler = getScheduled();
        // 任务名，任务组，任务执行类
        JobDetail jobDetail= JobBuilder.newJob(jobClazz)
                .withIdentity(jobName, jobGroupName)
                .storeDurably() //配置存储到数据库
                .build();
        // 传参（可选）
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        if(params != null ){
            params.forEach(jobDataMap::put);
        }

        //触发器时间设置
        CronScheduleBuilder cronBuilder = CronScheduleBuilder.cronSchedule(cron);
        // 触发器创建，创建Trigger对象
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jobName, triggerGroupName)// 触发器名（设置为任务名）,触发器组名称
                .withSchedule(cronBuilder) // 触发器时间设定
                .startNow().build();

        // 调度容器设置JobDetail和Trigger
        scheduler.scheduleJob(jobDetail, trigger);
        // 启动定时任务
        if (!scheduler.isShutdown()) {
            scheduler.start();
        }
    }

    /**
     * 更新定时任务的cron表达式--根据定时任务名称
     * @author kevin
     * @param triggerGroupName 需要修改的定时任务的触发器分组名称
     * @param jobName 需要修改的定时任务的名称
     * @param cron    新的cron表达式
     * @date 2022/5/24 17:13
     */
    public void updateJob(String triggerGroupName, String jobName, String cron) throws SchedulerException{
        //获取Scheduler
        Scheduler scheduler = getScheduled();

        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, triggerGroupName);
        // 触发器时间定义
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        // 创建Trigger对象
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerKey)
                .withSchedule(scheduleBuilder)
                .build();
        scheduler.rescheduleJob(triggerKey, cronTrigger);
    }

    /**
     * 删除定时任务--根据定时任务名称
     * @param jobGroupName job任务分组名称
     * @param triggerGroupName job触发器分组名称
     * @param jobName 任务名称
     */
    public void removeJob(String jobGroupName, String triggerGroupName, String jobName)  throws SchedulerException{
        Scheduler scheduler = getScheduled();
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, triggerGroupName);
        scheduler.pauseTrigger(triggerKey);// 停止触发器
        scheduler.unscheduleJob(triggerKey);// 移除触发器
        scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
    }

    /**
     * 获取所有定时任务
     * @author kevin
     * @return java.util.List<java.lang.String>
     * @date 2022/5/24 17:06
     */
    public List<String> getAllJob() throws SchedulerException{
        List<String> jobs = new ArrayList<>();
        Set<JobKey> jobKeys = getScheduled().getJobKeys(GroupMatcher.anyGroup());
        for(JobKey jobKey:jobKeys){
            jobs.add(jobKey.getName());
        }
        return jobs;
    }

    /**
     * 停止所有的定时任务
     * @author kevin
     * @date 2022/5/24 17:05
     */
    public void shutdownJobs() throws SchedulerException{
        Scheduler scheduler = getScheduled();
        if (!scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }

    /**
     * 启动所有的定时任务
     * @author kevin
     * @date 2022/5/24 17:05
     */
    public void startJobs() throws SchedulerException{
        Scheduler scheduler = getScheduled();
        scheduler.start();
    }
}