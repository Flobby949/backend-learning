package top.flobby.advanced.collection;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : HashMap
 * @create : 2023-03-07 09:32
 **/

public class HashMapSample {
    public static void main(String[] args) {
        // 实例化HashMap，HashMap在java.util包下
        HashMap<String, Object> student = new HashMap<>();
        // put方法插入键值对
        student.put("name", "张三");

        // 对同一个Key赋值，会覆盖原来的value，同时返回旧的value
        String oldName = (String) student.put("name", "李四");
        System.out.println(oldName);

        // Map可以存储多个键值对
        student.put("age", 18);
        student.put("height", 182);
        student.put("weight", 81);
        System.out.println(student);

        // get方法获取指定key的value
        String name = (String) student.get("name");
        System.out.println("指定key的value：" + name);

        // containsKey 用于判断的key是否存在
        boolean r1 = student.containsKey("name");
        System.out.println("判断key是否存在：" + r1);

        // containsKey 用于判断的key是否存在
        boolean r2 = student.containsValue(11);
        System.out.println("判断value是否存在：" + r2);

        // size返回键值对总数
        int count = student.size();
        System.out.println("键值对总数：" + count);


        // remove方式将指定的键值对删除，并返回value
        Integer remove = (Integer) student.remove("weight");
        System.out.println("weight项被移除，值为：" + remove);
        System.out.println("删除后map：" + student);

    }
}
