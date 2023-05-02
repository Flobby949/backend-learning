package top.flobby.sms.context;

import top.flobby.common.exception.ServerException;
import top.flobby.sms.config.SmsConfig;
import top.flobby.sms.enums.SmsPlatformEnum;
import top.flobby.sms.strategy.AliyunSmsStrategy;
import top.flobby.sms.strategy.SmsStrategy;

import java.util.Map;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : context
 * @create : 2023-05-02 22:08
 **/

public class SmsContext {
    private final SmsStrategy smsStrategy;

    public SmsContext(SmsConfig config) {
        if (config.getPlatform() == SmsPlatformEnum.ALIYUN.getValue()) {
            this.smsStrategy = new AliyunSmsStrategy(config);
        } else if (config.getPlatform() == SmsPlatformEnum.TENCENT.getValue()) {
            // TODO 腾讯云短信发送
            this.smsStrategy = null;
        } else {
            throw new ServerException("未知的短信平台");
        }
    }

    public void send(String mobile, Map<String, String> params) {
        smsStrategy.send(mobile, params);
    }
}
