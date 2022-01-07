package com.refer.service;

import java.util.List;
import java.util.Map;

import com.refer.jdbc.CommonDao;

public class BBSService {
	static CommonDao commonDao;
	
	public static List<Map<String, Object>> selectRecord(){
		//String[] inputArr = {"test"};
		String[] outputArr = {"이름", "아이디", "작성자", "내용", "작성일자"};
		String sql = "SELECT * FROM `jobsjo88`.`기록` ORDER BY `아이디` DESC LIMIT 1000;";
		
		return CommonDao.selectList(sql
				, null
				, outputArr);
	}
}
