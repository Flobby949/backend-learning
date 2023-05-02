package top.flobby.sms.strategy;

import java.util.Map;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 短信策略
 * @create : 2023-05-02 22:07
 **/

public interface SmsStrategy {

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param params 参数
     */
    void send(String mobile, Map<String, String> params);
}
