package top.flobby.spring.task;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class SyncTaskTest {
    @Resource
    private SyncTask syncTask;

    @Test
    void testSync() throws InterruptedException {
        long start = System.currentTimeMillis();
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
        log.info("任务耗时：{} ms", (System.currentTimeMillis() - start));
    }

}