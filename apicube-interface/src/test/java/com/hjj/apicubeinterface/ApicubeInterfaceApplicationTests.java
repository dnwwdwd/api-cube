package com.hjj.apicubeinterface;

import com.hjj.apicubeclientsdk.client.ApiCubeClient;
import com.hjj.apicubeclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApicubeInterfaceApplicationTests {

    @Resource
    private ApiCubeClient apiCubeClient;

    @Test
    void contextLoads() {
        String result = apiCubeClient.getNameByGet("burger");
        User user = new User();
        user.setUsername("hejaijun");
        String usernameByPost = apiCubeClient.getUsernameByPost(user);
        System.out.println(result);
        System.out.println(usernameByPost);
    }
}
