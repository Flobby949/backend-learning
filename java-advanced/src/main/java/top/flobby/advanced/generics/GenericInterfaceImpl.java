package top.flobby.advanced.generics;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 泛型接口实现类
 * @create : 2023-03-22 14:16
 **/

public class GenericInterfaceImpl implements GenericInterface<String> {
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}
