package top.flobby.advanced.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-03-29 00:40
 **/

public class StreamDemo8 {
    public static void main(String[] args) {
        // 创建一个整型列表
        List<Integer> integers = Arrays.asList(10, 12, 9, 8, 20, 1);

        // 使用 findFirst() 获取当前流中的第一个元素
        Optional<Integer> first = integers.stream().findFirst();
        System.out.println(integers + "列表中第一个元素为：" + first);

        // 使用 findAny() 获取当前流中的任意元素
        Optional<Integer> any = integers.stream().findAny();
        System.out.println("列表中任意元素：" + any);

        // 使用 count() 获取当前流中元素总数
        long count = integers.size();
        System.out.println(integers + "列表中元素总数为" + count);

        // 使用 max(Comparator c) 获取流中最大值
        Optional<Integer> max = integers.stream().max(Integer::compare);
        System.out.println(integers + "列表中最大值为" + max);

        // 使用 min(Comparator c) 获取流中最小值
        Optional<Integer> min = integers.stream().min(Integer::compare);
        System.out.println(integers + "列表中最小值为" + min);
    }
}
