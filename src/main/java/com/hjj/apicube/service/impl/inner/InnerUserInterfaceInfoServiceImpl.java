package com.hjj.apicube.service.impl.inner;

import com.hjj.apicube.common.ErrorCode;
import com.hjj.apicube.exception.ThrowUtils;
import com.hjj.apicube.service.UserInterfaceInfoService;
import com.hjj.apicubecommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokerCount(long interfaceInfoId, long userId) {
        ThrowUtils.throwIf(interfaceInfoId <= 0 || userId <= 0, ErrorCode.PARAMS_ERROR);
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

}
