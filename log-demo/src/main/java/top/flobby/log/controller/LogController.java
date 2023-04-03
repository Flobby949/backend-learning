package top.flobby.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void printLog() {
        log.info("info");
        log.error("error");
        log.debug("debug");
        log.warn("warn");
        log.trace("trace");
    }
}
