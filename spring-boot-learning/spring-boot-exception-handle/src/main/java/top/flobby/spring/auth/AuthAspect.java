package top.flobby.spring.auth;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.flobby.spring.enums.ExceptionEnum;
import top.flobby.spring.exceptions.CustomException;

import java.lang.reflect.Method;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 检查 token 切面
 * @create : 2023-03-28 16:33
 **/

@Aspect
@Component
public class AuthAspect {

    @Around("@annotation(top.flobby.spring.auth.CheckToken)")
    public Object checkLogin(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = getRequest();
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            throw new CustomException(ExceptionEnum.NO_AUTHORIZATION);
        }
        return point.proceed();
    }

    @Around("@annotation(top.flobby.spring.auth.CheckAuthorization)")
    public Object checkAuthorization(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = getRequest();
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            throw new CustomException(ExceptionEnum.NO_AUTHORIZATION);
        }
        // 2. 验证用户角色是否匹配
        String role = request.getHeader("role");
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        CheckAuthorization annotation = method.getAnnotation(CheckAuthorization.class);
        String value = annotation.value();
        if (!value.equals(role)) {
            throw new CustomException(ExceptionEnum.NO_PERMISSION);
        }
        return point.proceed();
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest();
    }
}
