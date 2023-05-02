package top.flobby.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.flobby.security.mobile.MobileVerifyCodeService;
import top.flobby.sms.api.SmsApi;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description :
 * @create : 2023-05-02 23:06
 **/

@Service
@AllArgsConstructor
public class MobileVerifyCodeServiceImpl implements MobileVerifyCodeService {
    private final SmsApi smsApi;

    @Override
    public boolean verifyCode(String mobile, String code) {
        return smsApi.verifyCode(mobile, code);
    }
}
