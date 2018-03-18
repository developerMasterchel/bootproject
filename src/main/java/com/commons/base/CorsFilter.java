/**
 * 文件名    ： CorsFilter.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年5月21日
 * 修改内容：<修改内容>
 */
package com.commons.base;
import org.springframework.stereotype.Component;  

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;  
import java.io.IOException;  
  
/** 
 *  
 *  跨域过滤器 
 * @author meng 
 * @version  
 * @since 2016年6月19日 
 */  
//@WebFilter(filterName="myFilter",urlPatterns="/**")
@Component
public class CorsFilter implements Filter {  
  
    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CorsFilter.class);  
  
    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {  
        HttpServletResponse response = (HttpServletResponse) res;  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with"); 
        String url = req.getRemoteAddr(); 
		logger.debug(url);
        logger.debug("*********************************过滤器被使用**************************");  
        chain.doFilter(req, res);  
    }  
    public void init(FilterConfig filterConfig) {}  
    public void destroy() {}  
}  