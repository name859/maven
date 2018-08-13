package com.name859.common.search;

import java.util.LinkedHashMap;
import java.util.Map;

import com.name859.common.param.Param;

public class SearchParam {

	private boolean isSearch = false;
	private int searchOption = 1;
	private String searchValue;
	
	private String orderBy = "addTime";
	
	public String getParam() {
		Map<String, String> paramMap = new LinkedHashMap<String, String>();
		paramMap.put("searchOption", Integer.toString(searchOption));
		paramMap.put("searchValue", getSearchValue());
		
		return new Param().makeParam(paramMap);
	}
	
	public boolean isSearch() {
		if (searchOption > 0 && searchValue != null && !searchValue.equals("")) return true;
		
		return false;
	}
	
	public void setSearch(boolean isSearch) {
		this.isSearch = isSearch;
	}
	
	public int getSearchOption() {
		return searchOption;
	}
	
	public void setSearchOption(int searchOption) {
		this.searchOption = searchOption;
	}
	
	public String getSearchValue() {
		if (searchValue == null) searchValue = "";
		
		return searchValue;
	}
	
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	public String getOrderBy() {
		return orderBy;
	}
	
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	@Override
	public String toString() {
		return "SearchParam [isSearch=" + isSearch + ", searchOption=" + searchOption + ", searchValue=" + searchValue
				+ ", orderBy=" + orderBy + "]";
	}
	
}
