package com.name859.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;

public class GeneralServiceImpl<D, DD extends JpaRepository<D, Long>, PP extends PageParam, SP extends SearchParam> implements GeneralService<D, PP, SP> {

	@Autowired protected DD dao;
	
	@Override
	public D add(D domain) {
		return dao.save(domain);
	}
	
	@Override
	public D modify(D domain) {
		return dao.save(domain);
	}
	
	@Override
	public void deleteById(Long domainId) {
		dao.delete(domainId);
	}
	
	@Override
	public D findById(Long domainId) {
		return dao.findOne(domainId);
	}
	
	@Override
	public List<D> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Page<D> findAll(PP pageParam, SP searchParam) {
		PageRequest pageRequest = new PageRequest(pageParam.getCurrentPage(), pageParam.getViewRecord());
		
		return dao.findAll(pageRequest);
	}
	
}
