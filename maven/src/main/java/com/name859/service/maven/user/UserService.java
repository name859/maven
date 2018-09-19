package com.name859.service.maven.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;
import com.name859.dao.maven.user.UserDao;
import com.name859.domain.maven.user.User;
import com.name859.service.GeneralServiceImpl;

@Service
@Transactional
public class UserService extends GeneralServiceImpl<User, UserDao, PageParam, SearchParam> {

	@Override
	public Page<User> findAll(PageParam pageParam, SearchParam searchParam) {
		PageRequest pageRequest = new PageRequest(pageParam.getCurrentPage(), pageParam.getViewRecord(), new Sort(Direction.DESC, searchParam.getOrderBy()));
		
		Page<User> result = null;
		if (searchParam.isSearch()) {	
			switch(searchParam.getSearchOption()) {
			case 1 :
				result = findByName(searchParam, pageRequest);
			}
		} else {
			result = dao.findAll(pageRequest);
		}
		if (result == null) throw new NullPointerException();
		
		return result;
	}
	
	public Page<User> findByName(SearchParam searchParam, PageRequest pageRequest) {
		return dao.findByNameLike("%"+ searchParam.getSearchValue() +"%", pageRequest);
	}
	
	public Page<User> findByVitalY(PageParam pageParam, SearchParam searchParam) {
		PageRequest pageRequest = new PageRequest(pageParam.getCurrentPage(), pageParam.getViewRecord(), new Sort(Direction.DESC, searchParam.getOrderBy()));
		
		Page<User> result = null;
		if (searchParam.isSearch()) {	
			switch(searchParam.getSearchOption()) {
			case 1 :
				result = findByVitalYAndName(searchParam, pageRequest);
			}
		} else {
			result = findByVitalY(pageRequest);
		}
		if (result == null) throw new NullPointerException();
		
		return result;
	}
	
	public Page<User> findByVitalYAndName(SearchParam searchParam, PageRequest pageRequest) {
		return dao.findByVitalAndNameLike("Y", "%"+ searchParam.getSearchValue() +"%", pageRequest);
	}
	
	public Page<User> findByVitalY(PageRequest pageRequest) {
		return dao.findByVital("Y", pageRequest);
	}
	
}
