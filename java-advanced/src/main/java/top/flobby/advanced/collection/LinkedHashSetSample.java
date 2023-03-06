package top.flobby.advanced.collection;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : LinkedHashSet
 * @create : 2023-03-06 23:52
 **/

public class LinkedHashSetSample {
    public static void main(String[] args) {
        Set<String> mobileSet = new LinkedHashSet<>();
        mobileSet.add("Iphone");
        mobileSet.add("onePlus");
        mobileSet.add("HUAWEI");
        System.out.println(mobileSet);
    }
}
