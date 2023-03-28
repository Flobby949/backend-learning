package top.flobby.advanced.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-03-29 00:36
 **/

public class StreamDemo5 {
    public static void main(String[] args) {
        // 创建一个包含小写字母元素的字符串列表
        List<String> stringList = Arrays.asList("php", "js", "python", "java");
        // 调用 map() 方法，将String下的toUpperCase()方法作为参数，这个方法会被应用到每个元素上，映射成一个新元素，最后打印映射后的元素
        stringList.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
