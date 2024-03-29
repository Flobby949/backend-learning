package top.flobby.sms.service;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.flobby.sms.config.SmsConfig;
import top.flobby.sms.context.SmsContext;

import java.util.Map;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 服务
 * @create : 2023-05-02 22:09
 **/

@Slf4j
@Service
@AllArgsConstructor
public class SmsService {
    @Resource
    private SmsConfig smsConfig;

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param params 参数
     * @return 是否发送成功
     */
    public boolean send(String mobile, Map<String, String> params) {
        SmsConfig config = new SmsConfig();
        config.setPlatform(smsConfig.getPlatform());
        config.setTemplateId(smsConfig.getTemplateId());
        config.setSignName(smsConfig.getSignName());
        config.setAccessKey(smsConfig.getAccessKey());
        config.setSecretKey(smsConfig.getSecretKey());
        System.out.println(config);
        try {
            // 发送短信
            new SmsContext(config).send(mobile, params);
            return true;
        } catch (Exception e) {
            log.error("短信发送失败，手机号：{}", mobile, e);
            return false;
        }
    }

}
