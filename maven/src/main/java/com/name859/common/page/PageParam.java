package com.name859.common.page;

import java.util.LinkedHashMap;
import java.util.Map;

import com.name859.common.param.Param;

public class PageParam {

	private int currentPage = 0;
	private int viewRecord = 10;
	private int viewPage = 10;
	
	public String getParam() {
		Map<String, String> paramMap = new LinkedHashMap<String, String>();
		paramMap.put("currentPage", Integer.toString(currentPage));
		paramMap.put("viewRecord", Integer.toString(viewRecord));
		
		return new Param().makeParam(paramMap);
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getViewRecord() {
		return viewRecord;
	}
	
	public void setViewRecord(int viewRecord) {
		this.viewRecord = viewRecord;
	}
	
	public int getViewPage() {
		return viewPage;
	}
	
	public void setViewPage(int viewPage) {
		this.viewPage = viewPage;
	}
	
	@Override
	public String toString() {
		return "PageParam [currentPage=" + currentPage + ", viewRecord=" + viewRecord + ", viewPage=" + viewPage + "]";
	}
	
}
