package top.flobby.spring.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Flobby
 * @program : spring-mvc-learning
 * @description : 时间类型转换
 * @create : 2023-03-07 20:21
 **/

public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new IllegalArgumentException("无效日期格式，请使用这种格式：" + pattern);
        }
    }

    
}
