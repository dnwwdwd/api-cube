package com.hjj.apicube.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjj.apicube.common.ErrorCode;
import com.hjj.apicube.exception.ThrowUtils;
import com.hjj.apicube.mapper.UserInterfaceInfoMapper;
import com.hjj.apicube.service.UserInterfaceInfoService;
import com.hjj.apicubecommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 17653
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service实现
* @createDate 2024-02-18 18:24:06
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    @Transactional( rollbackFor = Exception.class)
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 判断
        ThrowUtils.throwIf(interfaceInfoId <= 0 || userId <= 0, ErrorCode.PARAMS_ERROR);
        UpdateWrapper<UserInterfaceInfo> queryWrapper = new UpdateWrapper<>();
        queryWrapper.eq("interfaceInfoId", interfaceInfoId);
        queryWrapper.eq("userId", userId);
        queryWrapper.gt("leftNum", 0);
        queryWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(queryWrapper);
    }
}