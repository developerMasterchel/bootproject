package com.commons.cedis;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisProvider {
	protected static final Logger LOG = LoggerFactory.getLogger(RedisProvider.class);  
    protected static JedisPool jedispool;  
    protected static int EXPIRE = 130;  
    static{  
        ResourceBundle bundle = ResourceBundle.getBundle("jedis");  
        if (bundle == null) {  
            throw new IllegalArgumentException(  
                    "[redis.properties] is not found!");  
        }  
  
        EXPIRE = Integer.valueOf(bundle.getString("redis.expire").trim());  
          
        JedisPoolConfig jedisconfig = new JedisPoolConfig();  
        jedisconfig.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxActive").trim()));  
        jedisconfig.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle").trim()));
        jedisconfig.setMinIdle(Integer.valueOf(bundle.getString("redis.pool.minIdle").trim()));
        jedisconfig.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWait").trim())); 
        
        jedisconfig.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow").trim()));  
        jedisconfig.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn").trim()));  
        String auth = bundle.getString("redis.pool.auth").trim();
        jedispool = new JedisPool(jedisconfig, bundle.getString("redis.ip").trim(), 
        		Integer.valueOf(bundle.getString("redis.port").trim()), 100000, auth);  
        
    }  
      
    public static Jedis getJedis() {  
        Jedis jedis = null;  
        try {  
            jedis = jedispool.getResource();  
        } catch (JedisConnectionException jce) {  
        	LOG.error("JedisConnectionException", jce);
            try {  
                Thread.sleep(3000);  
            } catch (InterruptedException e) {  
            	LOG.error("InterruptedException",e);  
            }  
            jedis = jedispool.getResource();  
        }  
        return jedis;  
    }  
  
    public static void returnResource(JedisPool pool, Jedis jedis) {  
        if (jedis != null) {  
            pool.returnResource(jedis);  
        }  
    } 
}
