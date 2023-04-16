package top.flobby.cache.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.flobby.cache.config.UserKeyGenerator;
import top.flobby.cache.entity.User;
import top.flobby.cache.mapper.UserMapper;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-04-16 19:57
 **/

@Service
@Slf4j
public class AnnotationUserService {
    @Resource
    private UserMapper userMapper;

    /**
     *
     * key 设置规则
     * @Cacheable(value = "user.get", key = "#root.methodName")
     * 前对象和当前类的信息
     * @Cacheable(value = "user.get", key = "#root.targetClass.simpleName")
     * 参数列表的某一个或某几个参数作为 key
     * @Cacheable(value = "user.get", key = "#root.args[0]")
     * 直接引用某一个 cache 的名称
     * @Cacheable(value = {"user.get", "user.find"}, key = "#root.caches[1]")
     * 自定义 key
     * {@link UserKeyGenerator}
     *
     * 其他属性
     * 如果查询的 id 是奇数才缓存，偶数不缓存
     * @Cacheable(value = "user.get", key = "#id", condition = "#id % 2 == 1")
     * 如果查询的结果中 name 包含 "张" ，那就不予缓存了
     * @Cacheable(value = "user.get", key = "#id", unless = "#result.name.contains('张')")
     */

    @Cacheable(value = "user.get")
    public User get(Integer id) {
        return userMapper.get(id);
    }

    @CachePut(value = "user.get", key = "#user.id")
    public User update(User user) {
        userMapper.updateById(user);
        return user;
    }

    @CacheEvict(value = "user.get", key = "#id")
    public void deleteById(Integer id) {
        // userMapper.deleteById(id);
        log.info("deleteById invoke ......");
    }

}
