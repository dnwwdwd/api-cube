package com.hjj.apicubeinterface.controller;

import com.hjj.apicubeclientsdk.model.User;
import com.hjj.apicubeclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 查询名称接口
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("yupi"));
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        // todo 实际情况应该是去数据库中查询是否已经分配给用户
        if (!"burger".equals(accessKey)) {
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
        // todo 验证时间戳是否在5分钟以内
        // if () {
        // }
        // todo 实际情况是根据accessKey从数据库中查出secretKey
        String serverSign = SignUtils.genSign(body, "abcdefg");
        if (!serverSign.equals(sign)) {
            throw new RuntimeException("无权限！！！！");
        }
        return "POST 你的名字是" + user.getUsername();
    }
}
