package top.flobby.advanced.generics;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 未知类型泛型接口实现类
 * @create : 2023-03-22 14:17
 **/

public class GenericInterfaceUnKnowImpl<T> implements GenericInterface<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        GenericInterface<Float> floatGenericInterface = new GenericInterfaceUnKnowImpl<>();
        floatGenericInterface.show(1100.0f);
    }
}
