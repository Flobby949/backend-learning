package top.flobby.security.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

/**
 * @author : Flobby
 * @program : spring-security-learning
 * @description : 代码生成器工具类
 * @create : 2023-04-02 10:17
 **/

public class AutoGeneratorUtils {
    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("kobe24");
        System.out.println(encode);
        FastAutoGenerator.create("jdbc:mysql://106.14.246.27:3306/db_security", "root", "kobe24")
                .globalConfig(builder -> {
                    builder.author("flobby") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\Users\\Flobby\\Desktop"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("top.flobby.security") // 设置父包名
                            .moduleName("auth") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E:\\java-projects\\backend-learning\\spring-security-learning\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "tb_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
