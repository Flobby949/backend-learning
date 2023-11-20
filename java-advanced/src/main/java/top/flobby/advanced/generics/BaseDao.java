package top.flobby.advanced.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-11-20 14:15
 **/

public class BaseDao<T>{
    private Class clazz;

    public BaseDao(){
        Class clazz = this.getClass();
        ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
        clazz = (Class) type.getActualTypeArguments()[0];
        System.out.println(clazz);
    }

    public void save(T t){
        System.out.println("save " + t);
    }
}
