package com.hjj.apicube.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserInterfaceInfoServiceTest {

    @Resource
    UserInterfaceInfoService userInterfaceInfoService;

    @Test
    public void invokerCountTest() {
        boolean result = userInterfaceInfoService.invokerCount(1L, 1L);
        Assertions.assertTrue(result);
    }
}
