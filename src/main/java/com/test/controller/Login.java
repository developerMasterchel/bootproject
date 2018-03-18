/**
 * 文件名    ： Login.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年6月11日
 * 修改内容：<修改内容>
 */
package com.test.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.commons.session.MySessionContext;
import com.test.entity.SessionInfo;
import com.test.entity.User;
import com.test.form.UserForm;
import com.test.service.ILoginService;
import com.test.service.ISessionService;

@RestController
@EnableAutoConfiguration
@RequestMapping(path="/one") 
public class Login {

	protected final Logger log = LoggerFactory.getLogger(Login.class);
	
	@Resource(name="loginService")
	private ILoginService loginService;
	
	@Resource(name="sessionService")
	private ISessionService sessionService;
	
	@RequestMapping(path="/login")
	@ResponseBody
	public String login(HttpServletRequest request,UserForm form) throws Exception {
		log.info("/one");
		User obj = new User();
		obj.setNickName(form.getNickName());
		String sessionId = null;
		List<User> userList = loginService.findByParams(obj);
		if(userList.size() > 1){
			for (User user : userList) {
				if (user.getPassWord() == form.getPassWord()) {
					obj = user;
					SessionInfo sessionInfo = sessionService.findById(user.getId());
					if(null != sessionInfo){
						sessionId = sessionInfo.getSessionId();
					}
				}
				else{
					return "0";
				}
			}
			MySessionContext myc= MySessionContext.getInstance();
			if(null != sessionId){
				HttpSession sess = myc.getSession(sessionId);
				myc.DelSession(sess);
			}
			HttpSession session = request.getSession();
			myc.AddSession(session);
			SessionInfo info = new SessionInfo();
			info.setSessionId(session.getId());
			info.setUserId(obj.getId());
			sessionService.insert(info);
		}
		return "1";
	}
}
