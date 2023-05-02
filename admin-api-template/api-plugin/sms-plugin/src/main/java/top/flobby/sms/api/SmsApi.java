package top.flobby.sms.api;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : api
 * @create : 2023-05-02 22:09
 **/

public interface SmsApi {
    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param key    redis key
     * @param value  redis value
     * @return 发送结果
     */
    boolean sendCode(String mobile, String key, String value);

    /**
     * 验证
     *
     * @param mobile 手机号
     * @param code   验证码
     * @return 验证结果
     */
    boolean verifyCode(String mobile, String code);
}
