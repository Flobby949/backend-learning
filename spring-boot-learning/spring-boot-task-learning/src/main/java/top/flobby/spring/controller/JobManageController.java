package top.flobby.spring.controller;

import org.quartz.Job;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.flobby.spring.config.QuartzManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 定时任务管理接口
 * @create : 2023-04-08 10:55
 **/

@RestController
@RequestMapping("/job")
public class JobManageController {

    @Autowired
    private QuartzManager quartzManager;

    /**
     * 删除job
     * @author kevin
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @date 2022/5/24 17:57
     */
    @GetMapping("/getJobs")
    public Map<String, Object> getJobs() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("code", 200);
            result.put("msg", "定时任务列表查询成功！");
            result.put("data", quartzManager.getAllJob());
            return result;
        } catch (SchedulerException e) {
            e.printStackTrace();
            result.put("code", 201);
            result.put("msg", "定时任务列表查询失败！");
            result.put("data", null);
            return result;
        }

    }

    /**
     * 新增job任务
     *
     * @param jobName          job名称
     * @param jobGroupName     job分组名称
     * @param triggerGroupName 触发器分组名称
     * @param className        需要执行的job的类名
     * @param cron             cron 表达式
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @PostMapping("/addJob")
    public Map<String, Object> addJob(String jobName, String jobGroupName, String triggerGroupName,
                                      String className, String cron, Map<String, String> params) {
        Class<? extends Job> jobClass;
        try{
            jobClass = (Class<? extends Job>) Class.forName("top.flobby.spring.task." + className);
            quartzManager.addJob(jobGroupName, triggerGroupName, jobName, jobClass, cron, params);
        }catch (ClassNotFoundException e){
            Map<String, Object> result = new HashMap<>();
            result.put("code", 201);
            result.put("msg", "定时任务不存在！");
            result.put("data", null);
            return result;
        } catch (SchedulerException e) {
            Map<String, Object> result = new HashMap<>();
            result.put("code", 201);
            result.put("msg", "定时任务创建失败！");
            result.put("data", null);
            return result;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "定时任务创建成功！");
        result.put("data", null);
        return result;
    }

    /**
     * 修改定时任务
     * @param triggerGroupName 需要修改的定时任务的触发器分组名称
     * @param jobName 需要修改的定时任务的名称
     * @param cron    新的cron表达式
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @PutMapping("/updateJob")
    public Map<String, Object> updateJob(String triggerGroupName, String jobName, String cron) {
        try {
            quartzManager.updateJob(triggerGroupName, jobName, cron);
        } catch (SchedulerException e) {
            e.printStackTrace();
            Map<String, Object> result = new HashMap<>();
            result.put("code", 201);
            result.put("msg", "定时任务更新失败！");
            result.put("data", null);
            return result;
        }
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "定时任务更新成功！");
        result.put("data", null);
        return result;
    }

    /**
     * 删除job
     * @param jobGroupName     定时任务分组名称
     * @param triggerGroupName 触发器分组名称
     * @param jobName          定时任务名称
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @DeleteMapping("/deleteJob")
    public Map<String, Object> deleteJob(String jobGroupName, String triggerGroupName, String jobName) {
        try {
            quartzManager.removeJob(jobGroupName, triggerGroupName, jobName);
        } catch (SchedulerException e) {
            e.printStackTrace();
            Map<String, Object> result = new HashMap<>();
            result.put("code", 201);
            result.put("msg", "定时任务更新失败！");
            result.put("data", null);
            return result;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "定时任务删除成功！");
        result.put("data", null);
        return result;
    }
}
