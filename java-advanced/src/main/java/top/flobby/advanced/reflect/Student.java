package top.flobby.advanced.reflect;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 学生类
 * @create : 2023-03-22 14:44
 **/

public class Student {

    /**
     * 昵称
     */
    private String nickname;

    public Student() {
    }

    public Student(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 方法一：类名.class
        Class studentClass = Student.class;
        System.out.println(studentClass);
        // 方法二：对象.getClass()
        Student student = new Student();
        Class studentClass1 = student.getClass();
        System.out.println(studentClass1);
        // 方法三：Class.forName("包名类名")
        Class studentClass2 = Class.forName("top.flobby.advanced.reflect.Student");
        System.out.println(studentClass2);
    }
}
