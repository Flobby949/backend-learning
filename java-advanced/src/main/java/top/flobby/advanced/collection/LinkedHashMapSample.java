package top.flobby.advanced.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : LinkedHashMapSample
 * @create : 2023-03-09 20:41
 **/

public class LinkedHashMapSample {
    public static void main(String[] args) {
        Map<String, Object> myMap = new LinkedHashMap<>();
        myMap.put("name", "张三");
        myMap.put("age", 21);
        myMap.put("height", 182);
        myMap.put("weight", 60);
        // 按插入顺序提取数据
        System.out.println(myMap);
    }
}
