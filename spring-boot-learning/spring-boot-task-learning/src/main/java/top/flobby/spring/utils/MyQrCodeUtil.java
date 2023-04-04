package top.flobby.spring.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : 二维码工具
 * @create : 2023-04-04 15:29
 **/

public class MyQrCodeUtil {
    public static void createQrCode(String content, String output) {
        if (FileUtil.exist(output)) {
            FileUtil.del(output);
        }
        QrCodeUtil.generate(content, 300, 300, FileUtil.file(output));
    }
}
