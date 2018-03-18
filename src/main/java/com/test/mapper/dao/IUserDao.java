package com.test.mapper.dao;

import java.io.Serializable;

import com.test.entity.User;

public interface IUserDao extends IBaseDao<User, Serializable>{
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}