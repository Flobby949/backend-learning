package top.flobby.spring.ioc;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 14:49
 **/

public class UserDaoImpl implements UserDao {
    @Override
    public void say() {
        System.out.println("UserDao say hello");
    }
}
