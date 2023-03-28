package top.flobby.advanced.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 收集
 * @create : 2023-03-29 00:40
 **/

public class StreamDemo10 {
    public static void main(String[] args) {
        // 创建一个整型列表
        List<Integer> integers = Arrays.asList(10, 12, 9, 8, 20, 1, 10);
        Set<Integer> collect = integers.stream().collect(Collectors.toSet());
        System.out.println(collect);
    }
}
