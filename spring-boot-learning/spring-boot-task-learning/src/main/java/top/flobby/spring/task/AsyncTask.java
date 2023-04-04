package top.flobby.spring.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
* @program : spring-boot-learning
* @description : 异步任务
* @author : Flobby
* @create : 2023-04-04 13:52
**/

@Component
public class AsyncTask extends AbstractTask{
    @Override
    @Async
    public void doTaskOne() throws InterruptedException {
        super.doTaskOne();
    }

    @Override
    @Async
    public void doTaskTwo() throws InterruptedException {
        super.doTaskTwo();
    }

    @Override
    @Async
    public void doTaskThree() throws InterruptedException {
        super.doTaskThree();
    }
}
