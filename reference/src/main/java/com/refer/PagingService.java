package com.refer;

import java.util.Iterator;

public class PagingService {
	public static void main(String[] args) {
		/*
		 * 한 페이지 결과 수	numOfRows	4	필	10	한 페이지 결과 수
			페이지 번호	pageNo	4	필	1	페이지번호
			데이터 총 개수	totalCount	4	필	1	데이터 총 개수
		 */
		
		String numOfRow = "10";
		String pageNo = "1";
		String totalCount = "44";
		
		int pageAmount = 0;
		int showPageSize = 5;
		
		double totalCountInt = Integer.parseInt(totalCount);
		double pageNoInt = Integer.parseInt(pageNo);
		double numOfRowInt = Integer.parseInt(numOfRow);
		
		pageAmount = (int) Math.ceil(totalCountInt / numOfRowInt);
		
		int[] showPageList = new int[showPageSize];
		if(pageNoInt >2) {
			if((showPageSize % 2) == 0) {
				// 짝수
				
			}else {
				// 홀수				
			}
		}else {
			for(int i= 1; i<= showPageSize; i++) {
				showPageList[i-1] = i;
			}
		}
		
		String result = "";
		for (int i = 0; i < showPageList.length; i++) {
			if(i != (showPageList.length -1)) {
				result += showPageList[i] + ",";
			}else {
				result += showPageList[i] ;
			}
		}
		
		System.out.println(result);
	}
}
