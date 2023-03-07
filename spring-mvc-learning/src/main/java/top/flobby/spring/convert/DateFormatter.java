package top.flobby.spring.convert;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author : Flobby
 * @program : spring-mvc-learning
 * @description : 日期转换类
 * @create : 2023-03-07 20:35
 **/

public class DateFormatter implements Formatter<Date> {
    String pattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return new SimpleDateFormat().format(object);
    }
}
