package top.flobby.spring.entity;

/**
 * @author : Flobby
 * @program : spring-mvc-learning
 * @description :
 * @create : 2023-03-07 19:36
 **/

public class CardItem {
    private String name;
    private String cover;
    private String des;

    public CardItem(String name, String cover, String des) {
        this.name = name;
        this.cover = cover;
        this.des = des;
    }

    public CardItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
