package top.flobby.spring.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 定时任务作业
 * @create : 2023-04-04 14:59
 **/

@Slf4j
@Component
public class ScheduledJobs {


    /**
     * 固定延迟工作
     * 方法结束五秒后再次执行
     */
    // @Scheduled(fixedDelay = 5000)
    public void fixedDelayJob() throws InterruptedException {
        log.info("fixedDelay 开始时间 {}", LocalDateTime.now());
        Thread.sleep(10 * 1000);
        log.info("fixedDelay 结束时间 {}", LocalDateTime.now());
    }


    /**
     * 固定频率工作
     * 每隔三秒运行一次
     * @throws InterruptedException 中断异常
     */
    // @Scheduled(fixedRate = 3000)
    public void fixedRateJob() throws InterruptedException {
        log.info("fixedRate 开始时间 {}", LocalDateTime.now());
        Thread.sleep(5 * 1000);
        log.info("fixedRate 结束时间 {}", LocalDateTime.now());
    }

    /**
     * cron表达式
     * 4 月 4 日 15 时 11 分 40 秒
     */
    @Scheduled(cron = "40 11 15 4 4 ?")
    public void cronJob() {
        log.info("生日快乐");
    }
}
