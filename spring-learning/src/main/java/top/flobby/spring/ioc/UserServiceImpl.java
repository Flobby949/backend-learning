package top.flobby.spring.ioc;

/**
 * @author : Flobby
 * @program : spring-learning
 * @description :
 * @create : 2023-03-06 15:12
 **/

public class UserServiceImpl implements UserService{
    private UserDao userDao;
    public String message;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void say() {
        System.out.println("UserServiceMessage:" + message);
        this.userDao.say();
    }


}
