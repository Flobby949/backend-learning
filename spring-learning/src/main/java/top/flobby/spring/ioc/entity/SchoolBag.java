package top.flobby.spring.ioc.entity;

import java.util.List;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 16:18
 **/

public class SchoolBag {
    private String color;
    private List<Pen> pencilCase;

    public void setColor(String color) {
        this.color = color;
    }

    public void setPencilCase(List<Pen> pencilCase) {
        this.pencilCase = pencilCase;
    }

    @Override
    public String toString() {
        return this.color + "的书包里有" + this.pencilCase;
    }
}
