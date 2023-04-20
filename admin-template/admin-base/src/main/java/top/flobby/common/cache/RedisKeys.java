package top.flobby.common.cache;

/**
 * @author : Flobby
 * @program : admin-template
 * @description : key 管理
 * @create : 2023-04-20 19:17
 **/

public class RedisKeys {
    /**
     * 验证码Key
     */
    public static String getCaptchaKey(String key) {
        return "sys:captcha:" + key;
    }

    /**
     * accessToken Key
     */
    public static String getAccessTokenKey(String accessToken) {
        return "sys:access:" + accessToken;
    }
}
