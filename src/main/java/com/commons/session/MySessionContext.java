/**
 * 文件名    ： MySessionContext.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2017年6月11日
 * 修改内容：<修改内容>
 */
package com.commons.session;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class MySessionContext {
	private static MySessionContext instance;
    private HashMap mymap;

    private MySessionContext() {
        mymap = new HashMap();
    }

    public static MySessionContext getInstance() {
        if (instance == null) {
            instance = new MySessionContext();
        }
        return instance;
    }

    public synchronized void AddSession(HttpSession session) {
        if (session != null) {
            mymap.put(session.getId(), session);
        }
    }

    public synchronized void DelSession(HttpSession session) {
        if (session != null) {
            mymap.remove(session.getId());
        }
    }

    public synchronized HttpSession getSession(String session_id) {
        if (session_id == null) return null;
        return (HttpSession) mymap.get(session_id);
    }
}
