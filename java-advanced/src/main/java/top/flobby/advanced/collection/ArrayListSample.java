package top.flobby.advanced.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 集合
 * @create : 2023-03-06 23:11
 **/

public class ArrayListSample {
    public static void main(String[] args) {
        // 实例化ArrayList集合，允许出现重复元素
        List<String> bookList = new ArrayList<>();
        bookList.add("三国演义");
        bookList.add("水浒传");
        bookList.add("三国演义");
        System.out.println("创建集合添加元素：" + bookList);

        // 获取指定列表元素
        System.out.println("获取指定元素：" + bookList.get(1));

        // 向指定位置插入元素
        bookList.add(1, "红楼梦");
        System.out.println("指定位置插入元素：" + bookList);

        // add方法返回值代表list是否发生变化
        boolean result = bookList.add("西游记");
        System.out.println("add 列表是否发生变化：" + result);

        // set方法用于更新指定索引数据，返回值是更新前的源数据
        String before = bookList.set(3, "西游记后传");
        System.out.println("set 原数据：" + before);
        System.out.println("set 更新后数组：" + bookList);

        // remove 两种形式
        // 按数据删除，传入数据，返回是否成功
        boolean removeValue = bookList.remove("西游记后传");
        System.out.println("按数据删除：" + removeValue);
        System.out.println("删除后数组：" + bookList);

        // 按索引位置删除
        String removeIndex = bookList.remove(0);
        System.out.println("被删除元素值：" + removeIndex);
        System.out.println("删除后数组：" + bookList);

        // 测试，Integer类型删除如何选择索引位置or数据
        System.out.println();
        System.out.println("测试：Integer类型集合如何删除");
        List<Integer> numberList = new ArrayList<>();
        numberList.add(3);
        numberList.add(15);
        numberList.add(8);
        numberList.add(0);
        numberList.add(2);
        numberList.remove(0);
        System.out.println("测试remove(0) 返回结果：" + numberList);
        // numberList.remove(15);
        // System.out.println("remove(15) 返回结果：" + numberList);
        // Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 15 out of bounds for length 4
        System.out.println("测试结果：integer类型集合只能按索引删除");
        System.out.println();
        // 集合长度
        System.out.println("集合长度：" + bookList.size());

        // 更新最后一个数据
        bookList.set(bookList.size() - 1, "测试更新最后一个");
        System.out.println("更新最后一个元素：" + bookList);

        // 删除最后一个元素
        bookList.remove(bookList.size() - 1);
        System.out.println("删除最后一个后的集合：" + bookList);
    }
}
