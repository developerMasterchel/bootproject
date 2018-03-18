package com.commons.base;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	protected final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
    public ResultMsg MethodArgumentNotValidHandler(HttpServletRequest request, Exception exception) throws Exception 
    {
		log.error(exception.getMessage(),exception);
	    //TODO 按需重新封装需要返回的错误信息  
          
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode("3");
        resultMsg.setMsg("异常！");
        return resultMsg; 
    }
}
