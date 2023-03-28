package top.flobby.advanced.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : JDK 8 新api
 * @create : 2023-03-28 23:57
 **/

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        System.out.println("------------- 获取今天 -------------");
        LocalDateTimeDemo.getNow();
        System.out.println("------------- 设置时间 -------------");
        LocalDateTimeDemo.setTime();
    }

    public static void getNow() {
        // 获取当前日期
        LocalDate localDate = LocalDate.now();
        // 获取当前时间
        LocalTime localTime = LocalTime.now();
        // 获取当前日期和时间
        LocalDateTime localDateTime = LocalDateTime.now();
        // 打印
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }

    public static void setTime() {
        // 2023-3-20
        LocalDate date = LocalDate.of(2023, 3, 20);
        // 14:15:10
        LocalTime time = LocalTime.of(14, 15, 10);
        // 将date和time组合成一个LocalDateTime
        LocalDateTime dateTime1 = LocalDateTime.of(date, time);
        // 设置 年、月、日、时、分、秒
        LocalDateTime dateTime2 = LocalDateTime.of(2023, 3, 21, 14, 14);
        System.out.println(dateTime1);
        System.out.println(dateTime2);
    }
}
