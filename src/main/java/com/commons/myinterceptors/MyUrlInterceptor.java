/**
 * 文件名    ： MyInterceptor.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年5月21日
 * 修改内容：<修改内容>
 */
package com.commons.myinterceptors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.commons.base.CorsFilter;

/**
 * <一句话功能简述> url拦截器 (控制器) <功能详细描述>
 * 
 * @author chen
 * @version [版本号，2016年10月30日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MyUrlInterceptor extends HandlerInterceptorAdapter {
	
	final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MyUrlInterceptor.class);  
	
	/** 拦截器 -- */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURL().toString(); 
		logger.debug(url);
		return super.preHandle(request, response, handler);
//		return true;
	}
	
	/**
	 * 执行完控制器后调用，即离开时
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
	}
	
}