package top.flobby.advanced.threadex;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 多线程4
 * @create : 2023-03-29 00:05
 **/

public class CallableDemo {

    static class MyThread implements Callable<String> {

        @Override
        public String call() { // 方法返回值类型是一个泛型，在上面 Callable<String> 处定义
            return "我是线程中返回的字符串";
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 常见实现类的实例
        Callable<String> callable = new MyThread();
        // 使用 FutureTask 类来包装 Callable 对象
        FutureTask<String> futureTask = new FutureTask<>(callable);
        // 创建 Thread 对象
        Thread thread = new Thread(futureTask);
        // 启动线程
        thread.start();
        // 调用 FutureTask 对象的 get() 方法来获得线程执行结束后的返回值
        String s = futureTask.get();
        System.out.println(s);
    }

}
