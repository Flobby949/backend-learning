package top.flobby.spring.ioc.entity;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 16:26
 **/

public class Person {
    private String name;
    private Clothes clothes;

    public Person(String name, Clothes clothes) {
        this.name = name;
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return this.name + "穿着" + this.clothes;
    }
}
