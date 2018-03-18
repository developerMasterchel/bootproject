package com.test.cedis.serialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.commons.cedis.serialize.ListTranscoder;
import com.commons.cedis.serialize.ObjectsTranscoder;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * @author    Administrator
 * @version   [版本号，2017年5月11日]
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class TestSerializerTranscoder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5165983499895140457L;
	
	@Test  
    public void testObject() {  
        List<TestUser> lists = buildTestData();  
          
        TestUser userA = lists.get(0);  
          
        ObjectsTranscoder<TestUser> objTranscoder =  new ObjectsTranscoder<TestUser>();  
          
        byte[] result1 = objTranscoder.serialize(userA);  
          
        TestUser userA_userA = objTranscoder.deserialize(result1);  
          
        System.out.println(userA_userA.getName() + "\t" + userA_userA.getAge());  
    }  
      
    @Test  
    public void testList() {  
        List<TestUser> lists = buildTestData();  
          
  
        ListTranscoder<TestUser> listTranscoder = new ListTranscoder<TestUser>();  
          
        byte[] result1 = listTranscoder.serialize(lists);  
          
        List<TestUser> results = listTranscoder.deserialize(result1);  
      
        for (TestUser user : results) {  
            System.out.println(user.getName() + "\t" + user.getAge());  
        }  
          
    }
	      
    /**
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    private static List<TestUser> buildTestData() {  
        TestSerializerTranscoder tst = new TestSerializerTranscoder();  
        TestUser userA =  tst.new TestUser();  
        userA.setName("lily");   
        userA.setAge(25);  
          
          
        TestUser userB = tst.new TestUser();    
          
          
        userB.setName("Josh Wang");   
        userB.setAge(28);  
          
        List<TestUser> list = new ArrayList<TestUser>();    
        list.add(userA);    
        list.add(userB);    
          
        return list;    
    }
	      
    class TestUser implements Serializable {  
        private static final long serialVersionUID = 1L;  
  
            private String name;  
              
            private int age;  
              
  
            public String getName() {  
                return name;  
            }  
  
            public void setName(String name) {  
                this.name = name;  
            }  
  
            public int getAge() {  
                return age;  
            }  
  
            public void setAge(int age) {  
                this.age = age;  
            }  
   }
}
