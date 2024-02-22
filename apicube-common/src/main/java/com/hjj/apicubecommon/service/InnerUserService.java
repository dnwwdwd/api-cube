package com.hjj.apicubecommon.service;

import com.hjj.apicubecommon.model.entity.User;

/**
 * 用户服务
 */
public interface InnerUserService {
    User getInvokeUser(String accessKey, String secretKey);
}
