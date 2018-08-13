package com.name859.common.param;

import java.util.Map;
import java.util.Map.Entry;

import com.mysema.commons.lang.URLEncoder;

public class Param {

	public String makeParam(Map<String, String> paramMap) {
		int count = 0;
		String result = "";
		for (Entry<String, String> entry : paramMap.entrySet()) {
			if (count == 0) {
				result = entry.getKey() +"="+ entry.getValue();
			} else {
				result = result +"&"+ entry.getKey() +"="+ entry.getValue();
			}
			count++;
		}
		
		return URLEncoder.encodeURL(result);
	}
	
	public String makeParam(String... param) {
		int count = 0;
		String result = "";
		for (String p : param) {
			if (count == 0) {
				result = p;
			} else {
				result = result +"&"+ p;
			}
			count++;
		}
		
		return URLEncoder.encodeURL(result);
	}
	
}
