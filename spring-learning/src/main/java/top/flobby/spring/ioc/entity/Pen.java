package top.flobby.spring.ioc.entity;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 16:18
 **/

public class Pen {
    private String name;
    private String color;

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color + "的" + this.name;
    }
}
