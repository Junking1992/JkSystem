package com.jun.service;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class TestService {
	
	@Autowired
	public SessionFactory sf;
	
	public String testUpdate(String test){
		Session session = sf.openSession();
		String hql = "select pk_jar,code from mtws_jar where pk_jar='1001A4100000D721013 '";   
		String sql = "update mtws_rpwslog set impuser='"+test+"' where vinosity='MG5350'";   
		SQLQuery sqlQuery = session.createSQLQuery(sql); 
		int i = sqlQuery.executeUpdate();
        //默认查询出来的list里存放的是一个Object数组   
//	        List<Object[]> list = query.list();  
//	        StringBuffer sb = new StringBuffer();
//	        for(Object[] arr : list){
//	        	sb.append(arr[0]).append(arr[1]);
//	        }
//			return sb.toString();
//			if(true){ 
//				throw new Exception("Tset");
//			}
		int j = 1/0;
		System.out.println("-----------------------------------------------------close-------------------------");
		session.close();
		return i+"";
	}
}
