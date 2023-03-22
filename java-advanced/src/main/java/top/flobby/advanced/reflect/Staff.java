package top.flobby.advanced.reflect;

import java.lang.reflect.Field;

/**
 * @author : Flobby
 * @program : java-advanced
 * @description : 反射获取字段练习
 * @create : 2023-03-22 14:54
 **/

public class Staff {

    /**
     * 昵称 私有字段
     */
    private String nickname;

    /**
     * 私有字段
     */
    private float balance;

    /**
     * 公有字段
     */
    public String position;

    public Staff(String nickname, float balance, String position) {
        this.nickname = nickname;
        this.balance = balance;
        this.position = position;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static void main(String[] args) throws Exception {
        // 类名.class 方式获取 Class 实例
        Class<Staff> cls1 = Staff.class;
        // 获取 public 的字段 position
        Field position = cls1.getField("position");
        System.out.println("获取公有字段");
        System.out.println(position);

        // 获取字段 balance
        System.out.println("获取私有字段");
        Field balance = cls1.getDeclaredField("balance");
        System.out.println(balance);

        // 获取所有字段
        Field[] declaredFields = cls1.getDeclaredFields();
        System.out.println("获取全部字段");
        for (Field field : declaredFields) {
            System.out.print("name=" + field.getName());
            System.out.println("\t type=" + field.getType());
        }

        Staff staff = new Staff("Flobby", 10000.0f, "全栈工程师");
        Class<? extends Staff> staffClass = staff.getClass();
        Field positionField = staffClass.getField("position");
        Object o = positionField.get(staff);
        System.out.println("获取类公有字段值：" + o);

        Field nicknameField = staffClass.getDeclaredField("nickname");
        // 设置字段可以访问
        nicknameField.setAccessible(true);
        Object o1 = nicknameField.get(staff);
        System.out.println("获取类私有字段值：" + o1);
        // 设置字段值
        nicknameField.set(staff, "jjjcx");
        // 打印修改后的内容
        System.out.println("修改后的字段值：" + staff.getNickname());
    }

}
