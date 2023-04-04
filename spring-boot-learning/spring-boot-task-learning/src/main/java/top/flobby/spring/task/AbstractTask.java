package top.flobby.spring.task;

import lombok.extern.slf4j.Slf4j;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

/**
* @program : spring-boot-learning
* @description : 任务抽象类
* @author : Flobby
* @create : 2023-04-04 13:46
**/

@Slf4j
public abstract class AbstractTask {

    public void doTaskOne() throws InterruptedException {
        log.info("开始做任务一");
        long start = currentTimeMillis();
        // 执行任务
        sleep(10000);
        long end = currentTimeMillis();
        log.info("任务一耗时：{} ms", (end - start));
    }
    public void doTaskTwo() throws InterruptedException {
        log.info("开始做任务二");
        long start = currentTimeMillis();
        // 执行任务
        sleep(5000);
        long end = currentTimeMillis();
        log.info("任务二耗时：{} ms", (end - start));
    }
    public void doTaskThree() throws InterruptedException {
        log.info("开始做任务三");
        long start = currentTimeMillis();
        // 执行任务
        sleep(3000);
        long end = currentTimeMillis();
        log.info("任务三耗时：{} ms", (end - start));
    }
}
