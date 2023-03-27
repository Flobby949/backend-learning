package top.flobby.spring.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 自定义监听器
 * @create : 2023-03-27 14:46
 **/

@Slf4j
@WebListener
public class CustomListener implements ServletContextListener, ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("------------ servletContext 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("------------ servletContext 销毁");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        log.info("------------ request 属性新增");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        log.info("------------ request 属性移除");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        log.info("------------ request 属性修改");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("------------ request 初始化");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("------------ request 销毁");
    }
}
