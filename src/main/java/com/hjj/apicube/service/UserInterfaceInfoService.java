package com.hjj.apicube.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hjj.apicube.model.dto.userinterfaceinfo.UserInterfaceInfoQueryRequest;
import com.hjj.apicube.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 17653
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service
* @createDate 2024-02-18 18:24:06
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    QueryWrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest);

    boolean invokerCount(long interfaceInfoId, long userId);
}
