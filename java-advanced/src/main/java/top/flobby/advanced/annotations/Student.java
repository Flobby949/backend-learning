package top.flobby.advanced.annotations;

import java.lang.reflect.Field;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 学生类
 * @create : 2023-03-22 14:44
 **/

public class Student {

    /**
     * 标注注解
     */
    @Length(min = 2, max = 5, message = "昵称的长度必须在2 ~ 5之间")
    private String nickname;

    public Student(String nickname) {
        this.setNickname(nickname);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public void checkFieldLength(Student student) throws Exception {
        // 遍历所有Field
        for (Field field : student.getClass().getDeclaredFields()) {
            // 获取注解
            Length annotation = field.getAnnotation(Length.class);
            if (annotation != null) {
                // 获取字段
                Object o = field.get(student);
                if (o instanceof String) {
                    String stringField = (String) o;
                    if (stringField.length() < annotation.min() || stringField.length() > annotation.max()) {
                        throw new IllegalArgumentException(field.getName() + ":" + annotation.message());
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        // 实例化对象
        Student student = new Student("我的名字很长很长");
        System.out.println(student.getNickname());

        // 通过反射读取注解
        // isAnnotationPresent()判断Student类中的nickname字段上，是否存在@Length注解：
        boolean isLengthPresent =
                Student.class.getDeclaredField("nickname").isAnnotationPresent(Length.class);

        if (isLengthPresent) {
            Length annotation = Student.class.getDeclaredField("nickname").getAnnotation(Length.class);
            // 获取注解的参数值
            int min = annotation.min();
            int max = annotation.max();
            String message = annotation.message();
            // 打印参数值
            System.out.println(min);
            System.out.println(max);
            System.out.println(message);
        } else {
            System.out.println("在nickname字段上未发现Length注解");
        }

        // 校验注解是否生效
        student.checkFieldLength(student);
    }
}
