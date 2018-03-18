/**
 * 文件名    ： WebMvcConfigurer.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年5月30日
 * 修改内容：<修改内容>
 */
package com.commons.myinterceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

  public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new MyUrlInterceptor()).addPathPatterns("/**");
  }
}
