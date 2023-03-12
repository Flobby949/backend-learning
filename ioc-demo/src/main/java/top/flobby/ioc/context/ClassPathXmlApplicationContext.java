package top.flobby.ioc.context;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author : Flobby
 * @program : ioc-demo
 * @description :
 * @create : 2023-03-12 11:38
 **/

public class ClassPathXmlApplicationContext implements ApplicationContext{
    /**
     * ioc容器
     */
    private Map<String, Object> iocContainer = new HashMap<>();

    public ClassPathXmlApplicationContext() {
        String path = Objects.requireNonNull(
                this.getClass().getResource("/applicationContext.xml")).getPath();
        // 对路径进行解码，防止中文目录出现乱码
        path = URLDecoder.decode(path, StandardCharsets.UTF_8);
        //
        SAXReader reader = new SAXReader();
        try {
            // 根据路径进行读取
            Document document = reader.read(new File(path));
            // 获取所有的bean
            List<Node> beans = document.getRootElement().selectNodes("bean");
            // 对每一个bean进行操作
            for (Node bean : beans) {
                Element element = (Element) bean;
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                // 通过反射创建实例
                Class<?> c = Class.forName(className);
                // 通过无参构造器创建实例对象
                Object obj = c.getDeclaredConstructor().newInstance();
                // 通过反射机制，补充对象属性
                List<Node> propertyList = element.selectNodes("property");
                for (Node p : propertyList) {
                    Element property = (Element) p;
                    String name = property.attributeValue("name");
                    String value = property.attributeValue("value");
                    // 构造set方法方法名 -- setName
                    String setMethodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                    System.out.println("准备执行：" + setMethodName + " 方法");
                    // 获取set方法
                    Method setMethod = c.getMethod(setMethodName, String.class);
                    // 通过invoke调用set方法进行赋值
                    setMethod.invoke(obj, value);
                }
                iocContainer.put(id, obj);
                System.out.println(iocContainer);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("IoC容器初始化完毕");
    }

    @Override
    public Object getBean(String beanId) {
        return iocContainer.get(beanId);
    }
}
