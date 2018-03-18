package com.test.mapper.dao;

import java.io.Serializable;

import com.test.entity.SessionInfo;

public interface ISessionInfoDao extends IBaseDao<SessionInfo, Serializable>{
    int insert(SessionInfo record);

    int insertSelective(SessionInfo record);
}