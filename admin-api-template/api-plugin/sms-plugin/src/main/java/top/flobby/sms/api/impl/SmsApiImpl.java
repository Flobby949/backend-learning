package top.flobby.sms.api.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import top.flobby.sms.api.SmsApi;
import top.flobby.sms.cache.SmsSendCache;
import top.flobby.sms.service.SmsService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 服务实现
 * @create : 2023-05-02 22:10
 **/

@Component
@AllArgsConstructor
public class SmsApiImpl implements SmsApi {
    private final SmsService smsService;
    private final SmsSendCache smsSendCache;

    @Override
    public boolean sendCode(String mobile, String key, String value) {
        // 短信参数
        Map<String, String> params = new HashMap<>();
        params.put(key, value);
        // 发送短信
        boolean flag = smsService.send(mobile, params);
        if (flag) {
            smsSendCache.saveCode(mobile, value);
        }
        return flag;
    }

    @Override
    public boolean verifyCode(String mobile, String code) {
        String value = smsSendCache.getCode(mobile);
        if (value != null) {
            // 删除短信验证码
            smsSendCache.deleteCode(mobile);
            // 校验
            return value.equalsIgnoreCase(code);
        }
        return false;
    }
}
