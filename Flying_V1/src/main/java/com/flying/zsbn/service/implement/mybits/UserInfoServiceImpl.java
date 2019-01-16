package com.flying.zsbn.service.implement.mybits;

import com.flying.zsbn.commons.exception.ServiceException;
import com.flying.zsbn.dao.UserInfoMapper;
import com.flying.zsbn.model.UserInfo;
import com.flying.zsbn.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

//    private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(UserInfoServiceImpl.class);

    @Resource
    private UserInfoMapper userInfoMapper;

    public UserInfo selectById(Integer id){
        UserInfo userInfo = userInfoMapper.selectById(id);
        if(userInfo == null){
            throw new ServiceException("暂无该用户");
        }
        return userInfo;
    }

    @Override
    public PageInfo<UserInfo> selectAll(Integer page, Integer size) {
        //开启分页查询，写在查询语句上方
        //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
        PageHelper.startPage(page, size);
        List<UserInfo> userInfoList = userInfoMapper.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
        return pageInfo;
    }

}

