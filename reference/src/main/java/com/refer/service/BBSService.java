package com.refer.service;

import java.util.List;
import java.util.Map;

import com.refer.jdbc.CommonDao;

public class BBSService {
	static CommonDao commonDao;
	
	public static List<Map<String, Object>> selectRecord(){
		//String[] inputArr = {"test"};
		String[] outputArr = {"�̸�", "���̵�", "�ۼ���", "����", "�ۼ�����"};
		String sql = "SELECT * FROM `jobsjo88`.`���` ORDER BY `���̵�` DESC LIMIT 1000;";
		
		return CommonDao.selectList(sql
				, null
				, outputArr);
	}
}
