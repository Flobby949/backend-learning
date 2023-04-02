package top.flobby.security.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import top.flobby.security.auth.entity.User;

@SpringBootTest
class IUserServiceTest {
    @Resource
    private IUserService userService;

    @Test
    @DisplayName("根据用户名查询用户")
    void testMp() {
        User admin = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, "admin"));
        System.out.println(admin);
    }

    @Test
    @DisplayName("插入一条用户数据")
    void insertUserTest() {
        User user = new User();
        user.setUserName("admin");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        user.setLoginName("管理员");
        user.setPhone("13688888888");
        userService.save(user);
    }
}