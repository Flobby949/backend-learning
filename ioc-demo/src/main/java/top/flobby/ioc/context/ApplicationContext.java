package top.flobby.ioc.context;

/**
 * @author : JinChenXing
 * @program : ioc-demo
 * @description :
 * @create : 2023-03-12 11:36
 **/

public interface ApplicationContext {

    /**
     * 根据BeanId获取对应Bean实例
     *
     * @param beanId bean id
     * @return {@link Object}
     */
    Object getBean(String beanId);
}
