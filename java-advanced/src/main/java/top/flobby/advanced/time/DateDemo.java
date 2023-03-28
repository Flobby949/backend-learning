package top.flobby.advanced.time;

import java.util.Date;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : Date类练习
 * @create : 2023-03-28 23:53
 **/

public class DateDemo {
    public static void main(String[] args) {
        System.out.println("------------- 获取当前时间 -------------");
        DateDemo.getNowDate();
        System.out.println("------------- 获取当前时间毫秒 -------------");
        DateDemo.getNowNano();
    }

    public static void getNowDate() {
        // 实例化一个date对象
        Date date = new Date();
        // 调用 toString() 方法
        String s = date.toString();
        System.out.println(s);
    }

    public static void getNowNano() {
        // 实例化一个date对象
        Date date = new Date();
        // 调用 getTime() 方法
        long time = date.getTime();
        System.out.println(time);
    }
}
