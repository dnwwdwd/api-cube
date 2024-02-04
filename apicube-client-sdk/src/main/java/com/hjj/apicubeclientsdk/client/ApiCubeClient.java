package com.hjj.apicubeclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.hjj.apicubeclientsdk.model.User;
import com.hjj.apicubeclientsdk.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 调用第三方接口的客户端
 */
public class ApiCubeClient {

    private String accessKey;

    private String secretKey;

    public ApiCubeClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }


    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap();
        paramMap.put("name", name);
        String result = HttpUtil.get("http://localhost:8081/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost( String name) {
        HashMap<String, Object> paramMap = new HashMap();
        paramMap.put("name", name);
        String result = HttpUtil.post("http://localhost:8081/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getUsernameByPost(User user) {
        String jsonUser = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8081/api/name/user")
                .body(jsonUser)
                .addHeaders(getHeaderMap(jsonUser))
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }


    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        // 一定不能发送给后端
//        hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", SignUtils.genSign(body, secretKey));
        return hashMap;
    }

}
