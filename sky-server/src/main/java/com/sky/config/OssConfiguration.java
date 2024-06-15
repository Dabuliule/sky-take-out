package com.sky.config;

import com.sky.properties.MinioProperties;
import com.sky.utils.MinIOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class OssConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MinIOUtil minIOUtil(MinioProperties minioProperties) {
        log.info("开始创建MinIO文件上传工具类: {}", minioProperties);
        return new MinIOUtil(minioProperties.getEndpoint(),
                minioProperties.getAccessKey(),
                minioProperties.getSecretKey(),
                minioProperties.getBucketName());
    }
}
