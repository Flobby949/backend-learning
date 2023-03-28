package top.flobby.advanced.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 排序
 * @create : 2023-03-29 00:36
 **/

public class StreamDemo6 {
    public static void main(String[] args) {
        System.out.println("============ 默认排序 ===========");
        StreamDemo6.normalSort();
        System.out.println("============ 自定义排序 ===========");
        StreamDemo6.customSort();
    }

    public static void normalSort() {
        List<Integer> integers = Arrays.asList(10, 12, 9, 8, 20, 1);
        // 调用sorted()方法自然排序，并打印每个元素
        integers.stream().sorted().forEach(System.out::println);
    }

    public static void customSort() {
        List<Integer> integers = Arrays.asList(10, 12, 9, 8, 20, 1);
        // 定制排序
        integers.stream().sorted(
                (i1, i2) -> -Integer.compare(i1, i2)
        ).forEach(System.out::println);
    }
}
