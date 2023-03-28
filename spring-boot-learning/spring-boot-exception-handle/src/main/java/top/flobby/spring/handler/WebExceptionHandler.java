package top.flobby.spring.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.flobby.spring.enums.ExceptionEnum;
import top.flobby.spring.exceptions.CustomException;
import top.flobby.spring.util.AjaxResponse;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 自定义异常处理
 * @create : 2023-03-28 14:19
 **/

@Slf4j
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse handleCustomException(CustomException e) {
        if (e.getCode() == ExceptionEnum.SYSTEM_EXCEPTION.getCode()) {
            log.info(ExceptionEnum.SYSTEM_EXCEPTION.getDes());
        }
        return AjaxResponse.error(e);
    }
}
