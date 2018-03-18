/**
 * 文件名    ： MyBatisConfig.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年5月21日
 * 修改内容：<修改内容>
 */
package com.commons.page;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
//加上这个注解，使得支持事务
@EnableTransactionManagement
@MapperScan("com.test.mapper")
public class MyBatisConfig implements TransactionManagementConfigurer {

	@Autowired 
    private DataSource dataSource;
	
	/** * mybatis 配置路径 */ 
	private static String MYBATIS_CONFIG = "mybatis-config.xml";
	
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
//    	PagingInterceptor pageHelper = new PagingInterceptor();
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        /** 设置mybatis configuration 扫描路径 */
        bean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));

	//自定义数据库配置的时候，需要将pageHelper的bean注入到Plugins中，如果采用系统默认的数据库配置，则只需要定义pageHelper的bean，会自动注入。       

//        bean.setPlugins(new Interceptor[] { pageHelper });
        try {
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
