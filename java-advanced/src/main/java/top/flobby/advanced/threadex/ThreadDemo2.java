package top.flobby.advanced.threadex;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 多线程2
 * @create : 2023-03-29 00:04
 **/

public class ThreadDemo2 {
    /**
     * 静态内部类
     */
    static class MyThread extends Thread {

        private int i = 3;

        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (i > 0) {
                System.out.println(getName() + " i = " + i);
                i--;
            }
        }

    }

    public static void main(String[] args) {
        // 创建两个线程对象
        MyThread thread1 = new MyThread("线程1");
        MyThread thread2 = new MyThread("线程2");
        // 启动线程
        thread1.start();
        thread2.start();
    }
}
