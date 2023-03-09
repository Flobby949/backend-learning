package top.flobby.advanced.collection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : TreeMap
 * @create : 2023-03-09 20:43
 **/

public class TreeMapSample {

    /**
     * 自定义排序规则
     */
    static class RecordComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            // 降序
            return o2.compareTo(o1);
        }
    }

    public void sort() {
        Map<String, Object> record = new TreeMap<>(new RecordComparator());
        record.put("A1", "1");
        record.put("C3", "2");
        record.put("B5", "3");
        record.put("X1", "4");
        record.put("a2", "5");
        record.put("A2", "6");
        System.out.println(record);
    }

    public static void main(String[] args) {
        TreeMapSample sample = new TreeMapSample();
        sample.sort();
    }


}
