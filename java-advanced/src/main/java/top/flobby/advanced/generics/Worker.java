package top.flobby.advanced.generics;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description :
 * @create : 2023-11-20 14:15
 **/

public class Worker {
    private Integer id;
    private String name;

    public Worker(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Worker() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
