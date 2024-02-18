package com.hjj.apicube.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjj.apicube.common.ErrorCode;
import com.hjj.apicube.exception.BusinessException;
import com.hjj.apicube.exception.ThrowUtils;
import com.hjj.apicube.model.dto.userinterfaceinfo.UserInterfaceInfoQueryRequest;
import com.hjj.apicube.model.entity.InterfaceInfo;
import com.hjj.apicube.model.entity.UserInterfaceInfo;
import com.hjj.apicube.service.UserInterfaceInfoService;
import com.hjj.apicube.mapper.UserInterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author 17653
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service实现
* @createDate 2024-02-18 18:24:06
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0,
                    ErrorCode.PARAMS_ERROR, "接口或者用户不存在");
        }
        // 参数校验
        ThrowUtils.throwIf(userInterfaceInfo.getLeftNum() < 0, ErrorCode.PARAMS_ERROR, "剩余次数不能小于0");

    }

    @Override
    public QueryWrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest) {
        Long id = userInterfaceInfoQueryRequest.getId();
        Long userId = userInterfaceInfoQueryRequest.getUserId();
        Long interfaceInfoId = userInterfaceInfoQueryRequest.getInterfaceInfoId();
        Integer totalNum = userInterfaceInfoQueryRequest.getTotalNum();
        Integer leftNum = userInterfaceInfoQueryRequest.getLeftNum();
        Integer status = userInterfaceInfoQueryRequest.getStatus();

        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null && id > 0,"id", id);
        queryWrapper.eq(userId != null && userId > 0,"userId", userId);
        queryWrapper.eq(interfaceInfoId != null && interfaceInfoId > 0,"interfaceInfoId", interfaceInfoId);
        queryWrapper.eq(totalNum != null && totalNum > 0,"totalNum", totalNum);
        queryWrapper.eq(leftNum != null && leftNum > 0,"leftNum", leftNum);
        queryWrapper.eq(status != null && status > 0,"status", status);
        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean invokerCount(long interfaceInfoId, long userId) {
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