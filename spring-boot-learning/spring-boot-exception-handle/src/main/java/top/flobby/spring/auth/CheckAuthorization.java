package top.flobby.spring.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author :Flobby
 * @date :2023/3/28
 * @description :检查token注解
 */

@Retention(value = RetentionPolicy.RUNTIME)
public @interface CheckAuthorization {
    String value();
}
