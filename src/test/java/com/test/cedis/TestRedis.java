/**
 * 文件名    ： TestRedis.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年5月11日
 * 修改内容：<修改内容>
 */
package com.test.cedis;

import java.util.ArrayList;
import java.util.List;

import com.commons.base.ResultMsg;
import com.commons.cedis.RedisHelper;
import com.test.TestBean;

import redis.clients.jedis.Jedis;

public class TestRedis {
	
	public static void main(String[] args) {
		TestBean tb = new TestBean();
		tb.setName("bbb");
		ResultMsg rsm = new ResultMsg();
		rsm.setCode("001");
		rsm.setMsg("测试redis!");
		rsm.setData("111");
		List<ResultMsg> rlist = new ArrayList<ResultMsg>();
		rlist.add(rsm);
		
		long reslt = RedisHelper.setObject("one", "test", rsm);
		System.out.println(reslt);
		reslt = RedisHelper.setObject("one", "list", rlist);
		System.out.println(reslt);
		
		ResultMsg obj = (ResultMsg) RedisHelper.getObject("one", "test");
		System.out.println(obj.getCode());
		System.out.println(obj.getMsg());
		List<ResultMsg> res = (List<ResultMsg>) RedisHelper.getObject("one", "list");
		System.out.println(res.get(0).getMsg());
		
		RedisHelper.delAllObject("one");
		List<ResultMsg> l = (List<ResultMsg>) RedisHelper.getObject("one", "list");
		if (null == l) {
			System.out.println("clean");
		}
		System.out.println("complete!  ");
		
		
	}
	
	public static void main2(String[] args) {
		TestRedis a = new TestRedis();
		//连接redis服务器，192.168.0.100:6379
		Jedis jedis = new Jedis("192.168.0.105", 6379);
		//权限认证
	    jedis.auth("admin");  
	    
	    
	    jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin  
	    System.out.println(jedis.get("name"));//执行结果：xinxin  
	    jedis.append("name", " is my lover"); //拼接
	    System.out.println(jedis.get("name")); 
	    jedis.del("name");  //删除某个键
	    System.out.println(jedis.get("name"));
	     //设置多个键值对
	    jedis.mset("name","liuling","age","23","qq","476777XXX");
	    jedis.incr("age"); //进行加1操作
	    System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
	    jedis.del("name");  //删除某个键
	    jedis.del("age");  //删除某个键
	    jedis.del("qq");  //删除某个键
	}

}
