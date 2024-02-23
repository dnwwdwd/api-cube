package com.hjj.apicubecommon.service;

/**
* @author 17653
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service
* @createDate 2024-02-18 18:24:06
*/
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokerCount(long interfaceInfoId, long userId);
}
