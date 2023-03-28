package top.flobby.advanced.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : Stream流练习1
 * @create : 2023-03-29 00:30
 **/

public class StreamDemo1 {
    public static void main(String[] args) {

    }

    public static void createStream1() {
        // 创建一个集合，并添加几个元素
        List<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("world");
        stringList.add("java");

        // 通过集合获取串行 stream 对象
        Stream<String> stream = stringList.stream();
        // 通过集合获取并行 stream 对象
        Stream<String> personStream = stringList.parallelStream();
    }

    public static void createStream2() {
        // 初始化一个整型数组
        int[] arr = new int[]{1,2,3};
        // 通过整型数组，获取整形的 stream 对象
        IntStream stream1 = Arrays.stream(arr);

        // 通过字符串类型的数组，获取泛型类型为 String 的 stream 对象
        String[] stringArr = new String[]{"Hello", "World"};
        Stream<String> stream2 = Arrays.stream(stringArr);
    }

    public static void createStream3() {
        // 通过 Stream 类下的 of() 方法，创建 stream 对象、
        Stream<Integer> stream = Stream.of(1, 2, 3);
    }
}
