package top.flobby.advanced.threadex;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 多线程练习1
 * @create : 2023-03-29 00:03
 **/

public class ThreadDemo1 extends Thread {

    /**
     * 重写 Thread() 的方法
     */
    @Override
    public void run() {
        System.out.println("这里是线程体");
        // 当前打印线程的名称
        System.out.println(getName());
    }

    public static void main(String[] args) {
        // 实例化 ThreadDemo1 对象
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        // 调用 start() 方法，以启动线程
        threadDemo1.start();
    }

}