package com.hjj.apicube.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjj.apicubecommon.model.entity.UserInterfaceInfo;

/**
 * 用户接口信息服务
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
