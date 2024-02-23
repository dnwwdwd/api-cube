package com.hjj.apicube.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hjj.apicube.common.ErrorCode;
import com.hjj.apicube.exception.ThrowUtils;
import com.hjj.apicube.mapper.InterfaceInfoMapper;
import com.hjj.apicubecommon.model.entity.InterfaceInfo;
import com.hjj.apicubecommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        ThrowUtils.throwIf(StringUtils.isAnyBlank(url, method), ErrorCode.PARAMS_ERROR);
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper();
        queryWrapper.eq("url", url);
        queryWrapper.eq("method", method);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}
