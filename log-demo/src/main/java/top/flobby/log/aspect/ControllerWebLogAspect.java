package top.flobby.log.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.flobby.log.annotation.ControllerWebLog;
import top.flobby.log.utils.IpUtils;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author : Flobby
 * @program : log-demo
 * @description : 保存日志切面
 * @create : 2023-04-03 16:08
 **/

@Aspect
@Component
@Slf4j
public class ControllerWebLogAspect {

    @Pointcut("execution(public * top.flobby.log.controller..*.*(..))")
    public void WebLog() {
    }

    /**
     * 前置增强，执行方法前做什么
     *
     * @param joinPoint        切点
     * @param controllerWebLog 日志对象
     */
    @Before(value = "WebLog() && @annotation(controllerWebLog)")
    public void doBefore(JoinPoint joinPoint, ControllerWebLog controllerWebLog) {
        // 从请求上下文中获取request的属性集合
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        // 向下转型成sra
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        // 获取request对象
        assert sra != null;
        HttpServletRequest request = sra.getRequest();

        String ip = IpUtils.getIpAddr(request);
        String agent = request.getHeader("user-agent");
        if (agent.contains("Android") || agent.contains("iPhone")) {
            log.info("请求设备:\t手机");
        } else {
            log.info("请求设备:\t电脑");
        }
        log.info("请求IP:\t" + ip);
        log.info("请求方法:\t" + request.getMethod());
        log.info("请求URI:\t" + request.getRequestURI());
        log.info("接口方法名:\t" + controllerWebLog.name());

        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            log.info("参数数组" + Arrays.toString(args));
        }
    }

    /**
     * 环绕增强
     */
    @Around(value = "WebLog()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        ControllerWebLog annotation = method.getAnnotation(ControllerWebLog.class);
        String name = annotation.name();
        // 得到开始时间
        long start = System.currentTimeMillis();
        log.info("{} 方法开始时间 {}", name, LocalDateTime.now());
        // 执行目标方法
        Object ob = point.proceed();
        // 计算方法执行时间
        long takeTime = System.currentTimeMillis() - start;
        log.info("{} 方法耗时: {} ms", name, takeTime);
        return ob;
    }

    /**
     * 异常增强
     *
     * @param throwable 异常
     */
    @AfterThrowing(value = "WebLog()", throwing = "throwable")
    public void doThrowing(Throwable throwable) {
        // 从请求上下文中获取request的属性集合
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        // 向下转型成sra
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        // 获取request对象
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        log.error("{} 接口调用异常，异常信息 {}", request.getRequestURI(), throwable.getMessage());
    }
}

