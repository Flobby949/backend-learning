package top.flobby.cache.service;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import top.flobby.cache.entity.User;
import top.flobby.cache.mapper.UserMapper;

import java.util.List;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-04-16 19:57
 **/

@Service
public class CachedUserService implements InitializingBean {

    @Resource
    private CacheManager cacheManager;

    @Resource
    private UserMapper userMapper;

    private Cache cache;

    public  User get(Integer id){
        // 1. 通过CacheManager拿到名为user的缓存对象Cache
//        Cache cache = cacheManager.getCache("user");
        // 2. 从Cache中尝试获取一个指定id的User类型的对象
        assert cache != null;
        User user = cache.get(id, User.class);
        // 3. 如果对象数据存在，则直接返回
        if (user != null) {
            return user;
        }
        // 4. 如果数据不存在，则需要查询数据库，并将查询的结果放入Cache中
        User userFromDatabase = userMapper.get(id);
        cache.put(id, userFromDatabase);
        return userFromDatabase;
    }

    public List<User> findAll() {
        Cache cache = cacheManager.getCache("users");
        assert cache != null;
        List<User> users = cache.get("users", List.class);
        if (users != null) {
            return users;
        }
        List<User> usersFromDatabase = userMapper.findAll();
        cache.put("users", usersFromDatabase);
        return usersFromDatabase;
    }

    public List<User> findAllByNameLike(String name){
        return cache.get(name, () -> userMapper.findAllByNameLike(name));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.cache = cacheManager.getCache("user");
    }

}