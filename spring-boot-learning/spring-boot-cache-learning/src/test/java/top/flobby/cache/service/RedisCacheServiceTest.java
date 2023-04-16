package top.flobby.cache.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class RedisCacheServiceTest {
    @Resource
    private RedisCacheService redisCacheService;

    @Test
    void getName() {
        redisCacheService.getName(1);
        redisCacheService.getName(1);
        redisCacheService.getName(1);
    }

    @Test
    public void getUser() {
        redisCacheService.getUser(1);
        redisCacheService.getUser(1);
        redisCacheService.getUser(1);
    }
}