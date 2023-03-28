package top.flobby.spring.exceptions;

import lombok.Getter;
import top.flobby.spring.enums.ExceptionEnum;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 自定义异常
 * @create : 2023-03-28 14:18
 **/

@Getter
public class CustomException extends RuntimeException{
    private int code;
    private String msg;

    public CustomException() {}

    public CustomException(ExceptionEnum e) {
        this.code = e.getCode();
        this.msg = e.getDes();
    }

    public CustomException(ExceptionEnum e, String msg) {
        this.code = e.getCode();
        this.msg = msg;
    }
}
