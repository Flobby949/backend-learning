package top.flobby.log.annotation;

import java.lang.annotation.*;

/**
 * @author : Flobby
 * @program : log-demo
 * @description : 保存日志注解
 * @create : 2023-04-03 16:07
 **/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface ControllerWebLog {
    /**
     * name
     *
     * @return string
     */
    String name();
}
