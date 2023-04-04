package top.flobby.spring.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 异步回调任务
 * @create : 2023-04-04 14:05
 **/

@Component
public class AsyncCallbackTask  extends AbstractTask{

    @Async
    public Future<String> doTaskOneCallback() throws InterruptedException {
        super.doTaskOne();
        return new AsyncResult<String>("任务一完成");
    }

    @Async
    public Future<String> doTaskTwoCallback() throws InterruptedException {
        super.doTaskTwo();
        return new AsyncResult<String>("任务二完成");
    }

    @Async
    public Future<String> doTaskThreeCallback() throws InterruptedException {
        super.doTaskThree();
        return new AsyncResult<String>("任务三完成");
    }
}
