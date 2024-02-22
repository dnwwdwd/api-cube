package com.hjj.apicube.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hjj.apicube.common.ErrorCode;
import com.hjj.apicube.exception.ThrowUtils;
import com.hjj.apicube.mapper.UserMapper;
import com.hjj.apicubecommon.model.entity.User;
import com.hjj.apicubecommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey, String secretKey) {
        ThrowUtils.throwIf(StringUtils.isAnyBlank(accessKey, secretKey), ErrorCode.PARAMS_ERROR);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        queryWrapper.eq("secretKey", secretKey);
        return userMapper.selectOne(queryWrapper);
    }
}
