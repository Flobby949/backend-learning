package top.flobby.cache.service;

import jakarta.annotation.Resource;
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
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User get(Integer id){
        return userMapper.get(id);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public List<User> findAllByNameLike(String name){
        return userMapper.findAllByNameLike(name);
    }

}
