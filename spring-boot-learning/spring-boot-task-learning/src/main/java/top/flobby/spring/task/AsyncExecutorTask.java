package top.flobby.spring.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 通过线程池调度任务
 * @create : 2023-04-04 14:35
 **/

@Component
@Slf4j
public class AsyncExecutorTask extends AbstractTask{

    @Async()
    public Future<String> doTaskOneCallback() throws InterruptedException {
        super.doTaskOne();
        log.info("任务一，当前线程：{}", Thread.currentThread().getName());
        return new AsyncResult<String>("任务一完成");
    }

    @Async()
    public Future<String> doTaskTwoCallback() throws InterruptedException {
        super.doTaskTwo();
        log.info("任务二，当前线程：{}", Thread.currentThread().getName());
        return new AsyncResult<String>("任务二完成");
    }

    @Async()
    public Future<String> doTaskThreeCallback() throws InterruptedException {
        super.doTaskThree();
        log.info("任务三，当前线程：{}", Thread.currentThread().getName());
        return new AsyncResult<String>("任务三完成");
    }
}
