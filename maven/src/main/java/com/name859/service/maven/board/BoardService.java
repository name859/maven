package com.name859.service.maven.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;
import com.name859.dao.maven.board.BoardDao;
import com.name859.domain.maven.board.Board;
import com.name859.service.GeneralServiceImpl;

@Service
@Transactional
public class BoardService extends GeneralServiceImpl<Board, BoardDao, PageParam, SearchParam> {

	@Override
	public Page<Board> findAll(PageParam pageParam, SearchParam searchParam) {
		PageRequest pageRequest = new PageRequest(pageParam.getCurrentPage(), pageParam.getViewRecord(), new Sort(Direction.DESC, searchParam.getOrderBy()));
		
		Page<Board> result = null;
		if (searchParam.isSearch()) {	
			switch(searchParam.getSearchOption()) {
			case 1 :
				result = findByAll(searchParam, pageRequest);
				break;
			case 2 :
				result = findBySubject(searchParam, pageRequest);
				break;
			case 3 :
				result = findByContent(searchParam, pageRequest);
				break;
			case 4 :
				result = findByUserName(searchParam, pageRequest);
			}
		} else {
			result = dao.findAll(pageRequest);
		}
		if (result == null) throw new NullPointerException();
		
		return result;
	}
	
	public Page<Board> findByAll(SearchParam searchParam, PageRequest pageRequest) {
		String searchValue = "%"+ searchParam.getSearchValue() +"%";
		
		return dao.findBySubjectLikeOrContentLikeOrUserNameLike(searchValue, searchValue, searchValue, pageRequest);
	}
	
	public Page<Board> findBySubject(SearchParam searchParam, PageRequest pageRequest) {
		return dao.findBySubjectLike("%"+ searchParam.getSearchValue() +"%", pageRequest);
	}
	
	public Page<Board> findByContent(SearchParam searchParam, PageRequest pageRequest) {
		return dao.findByContentLike("%"+ searchParam.getSearchValue() +"%", pageRequest);
	}
	
	public Page<Board> findByUserName(SearchParam searchParam, PageRequest pageRequest) {
		return dao.findByUserNameLike("%"+ searchParam.getSearchValue() +"%", pageRequest);
	}
	
	public Page<Board> findByVitalY(PageParam pageParam, SearchParam searchParam) {
		PageRequest pageRequest = new PageRequest(pageParam.getCurrentPage(), pageParam.getViewRecord(), new Sort(Direction.DESC, searchParam.getOrderBy()));
		Page<Board> result = dao.findByVital("Y", pageRequest);
		
		if (result == null) throw new NullPointerException();
		
		return result;
	}
	
}
