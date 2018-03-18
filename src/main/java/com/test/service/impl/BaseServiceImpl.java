/**
 * 文件名    ： BaseServiceImpl.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年5月21日
 * 修改内容：<修改内容>
 */
package com.test.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.mapper.dao.IBaseDao;
import com.test.service.IBaseService;

public class BaseServiceImpl<T> implements IBaseService<T, Serializable>{
	
   @Autowired  
    private IBaseDao<T, Serializable> baseDao;  
      
    public IBaseDao<T, Serializable> getBaseDao() {  
        return baseDao;  
    }  
    public void setBaseDao(IBaseDao<T, Serializable> baseDao) {  
        this.baseDao = baseDao;  
    } 

	@Override
	public int insert(T t) throws Exception {
		return baseDao.insert(t);
	}

	@Override
	public int update(T t) throws Exception {
		return baseDao.update(t);
	}

	@Override
	public T findById(String id) throws Exception {
		return baseDao.findById(id);
	}

	@Override
	public List<T> findByParams(T t) throws Exception {
		return baseDao.findByParams(t);
	}
}
