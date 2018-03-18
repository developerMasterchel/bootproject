/**
 * 文件名    ： LoginImpl.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年6月11日
 * 修改内容：<修改内容>
 */
package com.test.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.User;
import com.test.mapper.dao.IBaseDao;
import com.test.service.ILoginService;

@Service(value = "loginService")
public class LoginImpl extends BaseServiceImpl<User>  implements ILoginService {
	
	@Override
	public List<User> findByParams(User t) throws Exception {
		return super.findByParams(t);
	}
}
