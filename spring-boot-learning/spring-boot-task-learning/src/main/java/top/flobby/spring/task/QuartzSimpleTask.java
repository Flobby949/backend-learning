package top.flobby.spring.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : Quartz任务类 Job
 * @create : 2023-04-08 10:26
 **/

public class QuartzSimpleTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz简单的定时任务执行时间："+new Date().toLocaleString());
    }
}
