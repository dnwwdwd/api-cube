package com.hjj.apicube.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hjj.apicube.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.hjj.apicubecommon.model.entity.InterfaceInfo;

/**
* @author 17653
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-02-02 18:32:37
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);
}
