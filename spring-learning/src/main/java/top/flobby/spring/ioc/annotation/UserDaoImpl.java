package top.flobby.spring.ioc.annotation;

import org.springframework.stereotype.Repository;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 14:49
 **/
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDaoImpl save");
    }
}

