package top.flobby.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.flobby.log.annotation.ControllerWebLog;

import java.util.Map;

/**
 * @author : Flobby
 * @program : log-demo
 * @description : 日志接口
 * @create : 2023-04-03 14:26
 **/

@Slf4j
@RestController
public class LogController {

    @GetMapping("logs")
    @ControllerWebLog(name = "不同级别日志打印方法")
    public void printLog() {
        log.info("info");
        log.error("error");
        log.debug("debug");
        log.warn("warn");
        log.trace("trace");
    }

    @GetMapping("errorMethod")
    @ControllerWebLog(name = "算数异常方法")
    public void errorMethod() {
        try {
            int i = 3 / 0;
            System.out.println(i);
        } catch (Exception e) {
            throw new ArithmeticException(e.getMessage());
        }
    }

    @PostMapping("params")
    @ControllerWebLog(name = "带参数方法")
    public void methodWithParams(@RequestParam int id,@RequestParam String name) {
        System.out.println("-------参数" + id);
        System.out.println("-------参数" + name);
    }

    @PostMapping("body")
    @ControllerWebLog(name = "带Json对象方法")
    public void methodWithBody(@RequestBody Map<String, Object> body) {
        System.out.println("-------参数" + body);
    }
}
