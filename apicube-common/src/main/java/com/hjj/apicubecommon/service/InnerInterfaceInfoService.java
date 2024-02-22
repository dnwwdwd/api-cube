package com.hjj.apicubecommon.service;

import com.hjj.apicubecommon.model.entity.InterfaceInfo;

/**
* @author 17653
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-02-02 18:32:37
*/
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在（请求路径、请求方法、请求参数，boolean）
     */
    InterfaceInfo getInterfaceInfo(String url, String method);
}
