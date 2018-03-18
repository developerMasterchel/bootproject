/**
 * 文件名    ： BaseService.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年5月21日
 * 修改内容：<修改内容>
 */
package com.test.service;

import java.util.List;

public interface IBaseService<T, Serializable> {
	
	public int insert(T t) throws Exception;
	
	public int update(T t) throws Exception;
	
	public T findById(String id) throws Exception;

	public List<T> findByParams(T t) throws Exception;

}
