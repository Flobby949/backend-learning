package top.flobby.advanced.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-03-29 00:39
 **/

public class StreamDemo7 {
    public static void main(String[] args) {
        // 创建一个整型列表
        List<Integer> integers = Arrays.asList(10, 12, 9, 8, 20, 1);
        // 使用 allMatch(Predicate p) 检查是否匹配所有元素，如果匹配，则返回 true；否则返回 false
        boolean b1 = integers.stream().allMatch(integer -> integer > 0);
        if (b1) {
            System.out.println(integers + "列表中所有的元素都大于0");
        } else {
            System.out.println(integers + "列表中不是所有的元素都大于0");
        }

        // 使用 anyMatch(Predicate p) 检查是否至少匹配一个元素
        boolean b2 = integers.stream().anyMatch(integer -> integer >= 20);
        if (b2) {
            System.out.println(integers + "列表中至少存在一个的元素都大于等于20");
        } else {
            System.out.println(integers + "列表中不存在任何一个大于等于20的元素");
        }

        // 使用 noneMath(Predicate p) 检查是否没有匹配所有元素
        boolean b3 = integers.stream().noneMatch(integer -> integer > 100);
        if (b3) {
            System.out.println(integers + "列表中不存在大于100的元素");
        } else {
            System.out.println(integers + "列表中存在大于100的元素");
        }
    }
}
