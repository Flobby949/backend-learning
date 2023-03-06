package top.flobby.advanced.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : HashSet
 * @create : 2023-03-06 23:41
 **/

public class HashSetSample {
    public static void main(String[] args) {
        // 实例化set集合
        Set<String> mobileSet = new HashSet<>();
        // add添加元素
        mobileSet.add("Iphone");
        mobileSet.add("onePlus");
        mobileSet.add("HUAWEI");
        System.out.println("add ：" + mobileSet);

        // set不允许出现重复，add返回值表示插入是否成功
        boolean isChanged = mobileSet.add("SAMSUNG");
        System.out.println("插入数据，Set是否发生变化：" + isChanged);
        // 插入重复
        isChanged = mobileSet.add("HUAWEI");
        System.out.println("插入重复数据，Set是否发生变化：" + isChanged);
        System.out.println("add 重复：" + mobileSet);

        // set可以使用所有Collection接口方法
        int size = mobileSet.size();
        System.out.println("set 长度：" + size);
        boolean result = mobileSet.contains("HUAWEI");
        System.out.println(mobileSet + "中是否包含 HUAWEI ：" + result);

        // get 等索引相关方法属于List接口，set不能使用
        // mobileSet.get(0);

    }
}
