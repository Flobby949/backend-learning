package top.flobby.spring.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AsyncCallbackTaskTest {
    @Resource
    private AsyncCallbackTask asyncCallbackTask;

    @Test
    void test01() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        Future<String> taskOne = asyncCallbackTask.doTaskOneCallback();
        Future<String> taskTwo = asyncCallbackTask.doTaskTwoCallback();
        Future<String> taskThree = asyncCallbackTask.doTaskThreeCallback();
        while (!taskOne.isDone() || !taskTwo.isDone() || !taskThree.isDone()) {
            sleep(1000);
        }
        System.out.println(taskOne.get());
        System.out.println(taskTwo.get());
        System.out.println(taskThree.get());
        log.info("任务耗时：{} ms", (System.currentTimeMillis() - start));
    }
}