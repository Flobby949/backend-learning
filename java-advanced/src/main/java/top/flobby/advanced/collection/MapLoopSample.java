package top.flobby.advanced.collection;

import java.util.*;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : Map遍历
 * @create : 2023-03-09 20:49
 **/

public class MapLoopSample {
    /**
     * for循环遍历map
     *
     * @param map map
     */
    public void doForLoop(Map<String, Object> map) {
        System.out.println("for循环");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + ":" + map.get(key));
        }
    }

    /**
     * forEach+Lambda
     *
     * @param map map
     */
    public void doForEach(Map<String, Object> map) {
        System.out.println("forEach+Lambda");
        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }

    /**
     * 迭代器
     *
     * @param map map
     */
    public void doIterator(Map<String, Object> map) {
        System.out.println("迭代器");
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> en = iterator.next();
            System.out.println(en.getKey() + ":" + en.getValue());
        }
    }

    public static void main(String[] args) {
        Map<String, Object> myMap = new HashMap<>(4);
        myMap.put("name", "张三");
        myMap.put("age", 21);
        myMap.put("height", 182);
        myMap.put("weight", 60);
        System.out.println("直接输出：" + myMap);

        MapLoopSample loopSample = new MapLoopSample();
        loopSample.doForLoop(myMap);
        loopSample.doForEach(myMap);
        loopSample.doIterator(myMap);
    }
}
