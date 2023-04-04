package top.flobby.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 任务线程池配置
 * @create : 2023-04-04 14:24
 **/

@Configuration
public class TaskThreadPoolConfig {

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(4);
        // 最大线程数
        executor.setMaxPoolSize(12);
        // 缓冲队列数，超过后开启新线程
        executor.setQueueCapacity(200);
        // 线程最大空闲时间，空线程超时销毁
        executor.setKeepAliveSeconds(120);
        // 线程临近饱和时拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 当线程池关闭时有未完成的方法，开启等待
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置关闭后等待时间，超时强制关闭
        executor.setAwaitTerminationSeconds(60);
        // 线程名前缀
        executor.setThreadNamePrefix("flobbyTask-");
        return executor;
    }
}
