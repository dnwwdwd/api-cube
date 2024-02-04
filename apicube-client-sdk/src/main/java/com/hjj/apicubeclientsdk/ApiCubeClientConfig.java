package com.hjj.apicubeclientsdk;

import com.hjj.apicubeclientsdk.client.ApiCubeClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("apicube.client")
@Data
@ComponentScan
public class ApiCubeClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public ApiCubeClient apiCubeClient() {
        return new ApiCubeClient(accessKey, secretKey);
    }
}
