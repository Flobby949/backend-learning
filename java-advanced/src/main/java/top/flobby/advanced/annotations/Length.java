package top.flobby.advanced.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author :Flobby
 * @date :2023/3/22
 * @description :自定义注解
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
public @interface Length {

    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default "长度不合法";

}
