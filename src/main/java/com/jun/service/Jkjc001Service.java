package com.jun.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Jkjc001Service {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public synchronized String getPubdoc(String input, String mode){
		//查询Sql
		String querySql = "";
		if("pk".equals(mode)){
			querySql = "select pk_pubdoc,code,name from mtws_pubdoc where pk_pubdoc like '"+input+"'";
		}else if ("code".equals(mode)){
			querySql = "select pk_pubdoc,code,name from mtws_pubdoc where code like '"+input+"'";
		}else if ("name".equals(mode)){
			querySql = "select pk_pubdoc,code,name from mtws_pubdoc where name like '"+input+"'";
		}
		
		if("".equals(input.trim()) || "".equals(mode.trim())){
			return "{}";
		}
		
		Session session = sessionFactory.openSession();
		List<Object[]> list = session.createSQLQuery(querySql).list();
		
		if(list.size() > 0){
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("value1", "pk_pubdoc");
			map1.put("value2", "code");
			map1.put("value3", "name");
			Map<String, Object> map2 = new HashMap<String, Object>();
			Object[] array = list.get(0);
			map2.put("value1", array[0]);
			map2.put("value2", array[1]);
			map2.put("value3", array[2]);
			List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
			data.add(map1);
			data.add(map2);
			return new JSONArray(data).toString();
		}
		
		return "{}";
	}

}
