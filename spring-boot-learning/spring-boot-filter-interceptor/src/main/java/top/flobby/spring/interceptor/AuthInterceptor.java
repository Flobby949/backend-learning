package top.flobby.spring.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 认证鉴权拦截器
 * @create : 2023-03-27 15:57
 **/

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("当前拦截URI：" + request.getRequestURI());
        String token = request.getHeader("Authorization");
        if (token != null) {
            if ("token".equals(token)) {
                log.info("访问成功");
                return true;
            } else {
                log.info("token错误");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
        } else {
            log.info("没有请求头");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }
}
