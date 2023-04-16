package top.flobby.cache.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.flobby.cache.entity.User;

import java.util.List;

@SpringBootTest
@Slf4j
class CachedUserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private CachedUserService cachedUserService;

    @Test
    public void test1() {
        User user1 = userService.get(1);
        User user2 = userService.get(1);
        log.info(String.valueOf(user1 == user2));
    }

    @Test
    public void test2() {
        User user1 = cachedUserService.get(1);
        User user2 = cachedUserService.get(1);
        log.info(String.valueOf(user1 == user2));
    }

    @Test
    public void test3() {
        List<User> users1 = cachedUserService.findAll();
        List<User> users2 = cachedUserService.findAll();
        log.info(String.valueOf(users1 == users2));
    }

    @Test
    public void test4() {
        List<User> users1 = cachedUserService.findAllByNameLike("张");
        List<User> users2 = cachedUserService.findAllByNameLike("张");
        log.info(String.valueOf(users1 == users2));
    }


}