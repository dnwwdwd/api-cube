package com.hjj.apicubeinterface.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 调用次数切面
 */
@RestControllerAdvice

public class InvokeCountAOP {
    // 伪代码
    // 定义切面的触发时机（什么时候执行方法）controller 接口的方法执行成功后，执行下述方法

    public void doInvokeCount(ProceedingJoinPoint point) {
        // 调用方法
        // 调用成功后，次数 + 1

    }
}
