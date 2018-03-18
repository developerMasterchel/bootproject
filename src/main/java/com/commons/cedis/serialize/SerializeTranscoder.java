package com.commons.cedis.serialize;

import java.io.Closeable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 序列化
 * @author Administrator
 *
 */
public abstract class SerializeTranscoder {
	 protected static Logger logger = LoggerFactory.getLogger(SerializeTranscoder.class);  
     
	    public abstract byte[] serialize(Object value);  
	      
	    public abstract Object deserialize(byte[] in);  
	      
	    public void close(Closeable closeable) {  
	        if (closeable != null) {  
	            try {  
	                closeable.close();  
	            } catch (Exception e) {  
	                 logger.info("Unable to close " + closeable, e);   
	            }  
	        }  
	    }  
}
