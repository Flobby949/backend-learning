package top.flobby.advanced.threadex;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 多线程5
 * @create : 2023-03-29 00:05
 **/

public class SleepDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            // 打印语句
            System.out.println(Thread.currentThread().getName() + ":执行第" + i + "次");
            try {
                // 使当前线程休眠
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        // 实例化 Runnable 的实现类
        SleepDemo sleepDemo = new SleepDemo();
        // 实例化线程对象
        Thread thread = new Thread(sleepDemo);
        // 启动线程
        thread.start();
    }

}
