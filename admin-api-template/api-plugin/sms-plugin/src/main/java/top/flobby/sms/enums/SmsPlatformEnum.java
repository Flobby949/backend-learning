package top.flobby.sms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description : 平台枚举
 * @create : 2023-05-02 22:04
 **/

@Getter
@AllArgsConstructor
public enum SmsPlatformEnum {
    /**
     * 阿里云
     */
    ALIYUN(0),
    /**
     * 腾讯云
     */
    TENCENT(1);

    private final int value;

}
