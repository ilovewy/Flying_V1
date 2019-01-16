package com.flying.zsbn.dao;

import com.flying.zsbn.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    UserInfo selectById(@Param("id") Integer id);

    List<UserInfo> selectAll(); //查询全部
}
