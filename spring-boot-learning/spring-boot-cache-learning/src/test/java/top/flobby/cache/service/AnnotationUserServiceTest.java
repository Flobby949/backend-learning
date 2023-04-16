package top.flobby.cache.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.flobby.cache.entity.User;

@SpringBootTest
@Slf4j
class AnnotationUserServiceTest {
    @Resource
    private AnnotationUserService annotationUserService;

    @Test
    void get() {
        User user1 = annotationUserService.get(1);
        User user2 = annotationUserService.get(1);
        log.info(String.valueOf(user1 == user2));
    }

    @Test
    public void testUpdate() {
        User user1 = annotationUserService.get(1);
        user1.setName("mybatis test");
        annotationUserService.update(user1);
        User user2 = annotationUserService.get(1);
        log.info(String.valueOf(user1 == user2));
    }

    @Test
    public void testDelete() {
        User user1 = annotationUserService.get(1);
        User user2 = annotationUserService.get(1);
        annotationUserService.deleteById(1);
        User user3 = annotationUserService.get(1);
        log.info(String.valueOf(user1 == user3));
    }
}