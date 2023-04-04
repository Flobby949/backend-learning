package top.flobby.spring.task;

import org.springframework.stereotype.Component;

/**
* @program : spring-boot-learning
* @description : 同步任务
* @author : Flobby
* @create : 2023-04-04 13:52
**/

@Component
public class SyncTask extends AbstractTask{
    @Override
    public void doTaskOne() throws InterruptedException {
        super.doTaskOne();
    }

    @Override
    public void doTaskTwo() throws InterruptedException {
        super.doTaskTwo();
    }

    @Override
    public void doTaskThree() throws InterruptedException {
        super.doTaskThree();
    }
}
