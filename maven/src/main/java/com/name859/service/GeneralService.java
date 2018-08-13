package com.name859.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;

public interface GeneralService<D, PP extends PageParam, SP extends SearchParam> {

	D add(D domain);
	
	D modify(D domain);
	
	void deleteById(Long domainId);
	
	D findById(Long domainId);
	
	List<D> findAll();
	
	Page<D> findAll(PP pageParam, SP searchParam);
	
}
