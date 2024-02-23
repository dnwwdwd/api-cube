package com.hjj.apicube.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjj.apicubecommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author 17653
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Mapper
* @createDate 2024-02-18 18:24:06
* @Entity com.hjj.apicube.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    // select interfaceInfoId,sum(totalNum) as totalNum from user_interface_info group by interfaceInfoId order by totalNum desc limit 3
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




