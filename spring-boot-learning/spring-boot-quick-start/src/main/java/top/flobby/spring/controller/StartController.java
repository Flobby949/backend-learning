package top.flobby.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.flobby.spring.common.RestResult;
import top.flobby.spring.entity.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description :
 * @create : 2023-03-13 15:47
 **/

@RestController
public class StartController {
    @GetMapping("list")
    public RestResult getCourseList() {
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(111, "Web应用开发", "mqxu", "2023/2 - 2023/3", true));
        courseList.add(new Course(222, "后端开发", "mqxu", "2023/3 - 2023/4", false));
        courseList.add(new Course(333, "前端开发", "mqxu", "2023/4 - 2023/5", false));
        courseList.add(new Course(444, "uni-app开发", "mqxu", "2023/5 - 2023/6", false));
        List<Course> closeCourse = courseList.stream().filter(item -> item.getIsClose()).toList();
        List<Course> openCourse = courseList.stream().filter(item -> !item.getIsClose()).toList();
        Map<String, List<Course>> resultMap = new HashMap<>(2);
        resultMap.put("closeCourse", closeCourse);
        resultMap.put("openCourse", openCourse);
        return RestResult.builder()
                .code(1)
                .msg("搜索成功")
                .data(resultMap)
                .build();
    }
}
