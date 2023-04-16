package top.flobby.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 自定义key生成
 * @create : 2023-04-16 20:12
 **/

@Component
public class UserKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        return method.getName() + params[0];
    }
}
