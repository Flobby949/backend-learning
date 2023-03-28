package top.flobby.advanced.time;

import java.util.Calendar;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 日历类练习
 * @create : 2023-03-28 23:55
 **/

public class CalendarDemo {

    public static void main(String[] args) {
        System.out.println("------------- 获取今天日历 -------------");
        CalendarDemo.getToday();
        System.out.println("------------- 设置一个日期 -------------");
        CalendarDemo.setDay();

    }

    public static void getToday() {
        Calendar calendar = Calendar.getInstance();
        // 获取今天是这一周的第几天
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        // 获取今天是这一月的第几天
        int i1 = calendar.get(Calendar.DAY_OF_MONTH);
        // 获取今天是这一月的第几周
        int i2 = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        // 获取今天是这一年的第几天
        int i3 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println("今天是这一周的第" + i + "天");
        System.out.println("今天是这一月的第" + i1 + "天");
        System.out.println("今天是这一月的第" + i2 + "周");
        System.out.println("今天是这一年的第" + i3 + "天");
    }

    public static void setDay() {
        Calendar calendar = Calendar.getInstance();
        // 设置2023年:
        calendar.set(Calendar.YEAR, 2023);
        // 设置3月: (2表示3月)
        calendar.set(Calendar.MONTH, 2);
        // 设置22日:
        calendar.set(Calendar.DATE, 28);
        // 设置时间:
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println(calendar.getTime());
    }
}
