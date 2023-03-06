package top.flobby.spring.ioc.entity;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 16:25
 **/

public class Clothes {
    private String style;
    private String color;

    public void setStyle(String style) {
        this.style = style;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color + "的" + this.style;
    }
}
