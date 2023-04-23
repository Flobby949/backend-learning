package top.flobby.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.flobby.mybatis.handler.FieldMetaObjectHandler;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : MP 配置
 * @create : 2023-04-23 17:26
 **/
@Configuration
public class MybatisPlusConfig {

    /**
     * MP 拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // 分页插件拦截器
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

    /**
     * 字段自动填充
     */
    @Bean
    public FieldMetaObjectHandler fieldMetaObjectHandler() {
        return new FieldMetaObjectHandler();
    }
}
