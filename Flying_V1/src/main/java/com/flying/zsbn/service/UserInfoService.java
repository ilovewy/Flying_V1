package com.flying.zsbn.service;

import com.flying.zsbn.model.UserInfo;
import com.github.pagehelper.PageInfo;

public interface UserInfoService {
    UserInfo selectById(Integer id);

    PageInfo<UserInfo> selectAll(Integer page, Integer size);
}
