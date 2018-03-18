/**
 * 文件名    ： SessionImpl.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年6月11日
 * 修改内容：<修改内容>
 */
package com.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.entity.SessionInfo;
import com.test.service.ISessionService;

@Service(value = "sessionService")
public class SessionImpl extends BaseServiceImpl<SessionInfo>  implements ISessionService {

	@Override
	public int insert(SessionInfo t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(SessionInfo t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SessionInfo findById(String id) throws Exception {
		return this.findById(id);
	}

	@Override
	public List<SessionInfo> findByParams(SessionInfo t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
