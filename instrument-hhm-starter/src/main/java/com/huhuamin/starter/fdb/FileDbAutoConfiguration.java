package com.huhuamin.starter.fdb;

import com.huhuamin.starter.fdb.aliyun.AliyunCosProperties;
import com.huhuamin.starter.fdb.aliyun.AliyunFileDbConfiguration;
import com.huhuamin.starter.fdb.qiniu.QiniuCosProperties;
import com.huhuamin.starter.fdb.qiniu.QiniuFileDbConfiguration;
import com.huhuamin.starter.fdb.tencent.TencentCosProperties;
import com.huhuamin.starter.fdb.tencent.TencentFileDbConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/5 14:52
 * @Description:
 */
@Configuration
@EnableConfigurationProperties({AliyunCosProperties.class, TencentCosProperties.class, QiniuCosProperties.class})
@Import({AliyunFileDbConfiguration.class, TencentFileDbConfiguration.class, QiniuFileDbConfiguration.class})
public class FileDbAutoConfiguration {

    public static String BEAN_NAME_FDB_ALIYUN_SERVICE = "fdbAliyunService";
    public static String BEAN_NAME_FDB_TENCENT_SERVICE = "fdbTencentService";
    public static String BEAN_NAME_FDB_QUNIU_SERVICE = "fdbQiniuService";


}
