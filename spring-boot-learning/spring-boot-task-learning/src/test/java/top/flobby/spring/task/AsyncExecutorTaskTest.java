package top.flobby.spring.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Thread.sleep;

@Slf4j
@SpringBootTest
class AsyncExecutorTaskTest {
    @Resource
    AsyncExecutorTask executorTask = new AsyncExecutorTask();

    @Test
    void test01() throws InterruptedException {
        long start = System.currentTimeMillis();
        executorTask.doTaskOneCallback();
        executorTask.doTaskTwoCallback();
        executorTask.doTaskThreeCallback();
        sleep(10L * 1000);
        log.info("任务耗时：{} ms", (System.currentTimeMillis() - start));
    }
}