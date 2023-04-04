package top.flobby.spring.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
class AsyncTaskTest {
    @Resource
    private AsyncTask asyncTask;

    @Test
    void testSync() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
        log.info("任务耗时：{} ms", (System.currentTimeMillis() - start));
    }
}