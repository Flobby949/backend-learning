package top.flobby.push.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : SSE 技术
 * @create : 2023-04-17 13:39
 **/

@Slf4j
@Controller
public class SSEController {

    @RequestMapping(value = "sse/msg", method = RequestMethod.GET, produces = "text/event-stream;charset-utf-8")
//    @Scheduled(fixedRate = 3000)
    public ResponseBodyEmitter pushMsg() {
        SseEmitter sseEmitter = new SseEmitter(0L);
        log.info("emitter push msg ...");
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int i = random.nextInt(100);
        try {
            Thread.sleep(1000);
            sseEmitter.send(sdf.format(new Date()) + "，价格为：" + i, MediaType.TEXT_EVENT_STREAM);
            return sseEmitter;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            sseEmitter.complete();
        }
    }
}
