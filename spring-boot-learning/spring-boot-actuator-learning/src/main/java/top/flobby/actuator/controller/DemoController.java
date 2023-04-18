package top.flobby.actuator.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-04-18 15:40
 **/

@RestController
public class DemoController {
    @Resource
    private MeterRegistry meterRegistry;

    private Counter counter;

    /**
     * 自定义 metrics 文档
     * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#actuator.metrics.registering-custom
     */
    @PostConstruct
    public void init() {
        counter = meterRegistry.counter("demo.request");
    }

    @GetMapping("demo")
    public double demo() {
        counter.increment();
        return counter.count();
    }
}
