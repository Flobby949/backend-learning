package top.flobby.cache.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.flobby.cache.entity.User;
import top.flobby.cache.mapper.UserMapper;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-04-16 20:19
 **/

@Service
@Slf4j
public class RedisCacheService {

    @Resource
    private UserMapper userMapper;

    @Cacheable(value = "getName")
    public String getName(Integer i) {
        log.info("getName invoke ......");
        return "name" + i;
    }

//    @Cacheable(value = "getUser")
//    public User getUser(Integer id) {
//        return userMapper.get(id);
//    }

    @Cacheable(value = "getUser", cacheManager = "userCacheManager")
    public User getUser(Integer id) {
        return userMapper.get(id);
    }
}
