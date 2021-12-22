package com.refer.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonDao {
	public static void main(String[] args) {
		//String[] inputArr = {"테스트"};
		String[] outputArr = {"이름", "아이디", "작성자", "내용", "작성일자"};
		selectList("SELECT * FROM `jobsjo88`.`기록` ORDER BY 작성일자 DESC LIMIT 1000;"
				, null
				, outputArr);
	}
	
	public static List<Map<String, Object>> selectList(String sql
			, String[] inputArr
			, String[] outputArr){
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		JDBCConnect dbconn = JDBCConnect.getInstance();
		Connection conn = dbconn.open();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Map<String, Object> map = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			System.out.println("sql: "+ sql);
			if(inputArr != null) {
				for (int i = 0; i < inputArr.length; i++) {
					String string = inputArr[i];
					
					pstmt.setString(i, string);
				}
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				map= new HashMap<String, Object>();
				if(outputArr != null) {
					for (int i = 0; i < outputArr.length; i++) {
						String string = outputArr[i];
						map.put(string, rs.getString(string));
					}
				}
				
				System.out.println(map);
				list.add(map);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbconn.close();
		}
		
		return list;
	}
}
