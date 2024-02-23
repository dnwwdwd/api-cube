package com.hjj.apicube.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hjj.apicube.common.ErrorCode;
import com.hjj.apicube.exception.ThrowUtils;
import com.hjj.apicube.mapper.UserMapper;
import com.hjj.apicubecommon.model.entity.User;
import com.hjj.apicubecommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        ThrowUtils.throwIf(StringUtils.isBlank(accessKey), ErrorCode.PARAMS_ERROR);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        return userMapper.selectOne(queryWrapper);
    }
}
