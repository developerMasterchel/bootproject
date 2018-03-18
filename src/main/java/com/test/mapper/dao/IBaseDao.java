/**
 * 文件名    ： BaseDao.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年5月21日
 * 修改内容：<修改内容>
 */
package com.test.mapper.dao;

import java.util.List;

public interface IBaseDao <T, Serializable>{
	
	int insert(T t) throws Exception;
	
	int update(T t) throws Exception;
	
	T findById(String id) throws Exception;
	
	int delete(Integer id);

	List<T> findByParams(T t) throws Exception;
}
