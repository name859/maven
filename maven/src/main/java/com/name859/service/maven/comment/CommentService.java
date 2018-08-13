package com.name859.service.maven.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;
import com.name859.dao.maven.comment.CommentDao;
import com.name859.domain.maven.comment.Comment;
import com.name859.service.GeneralServiceImpl;

@Service
@Transactional
public class CommentService extends GeneralServiceImpl<Comment, CommentDao, PageParam, SearchParam> {

	@Override
	public Page<Comment> findAll(PageParam pageParam, SearchParam searchParam) {
		PageRequest pageRequest = new PageRequest(pageParam.getCurrentPage(), pageParam.getViewRecord(), new Sort(Direction.DESC, searchParam.getOrderBy()));
		
		Page<Comment> result = null;
		if (searchParam.isSearch()) {	
			switch(searchParam.getSearchOption()) {
			case 1 :
				result = findByAll(searchParam, pageRequest);
				break;
			case 2 :
				result = findByComment(searchParam, pageRequest);
				break;
			case 3 :
				result = findByBoardSubject(searchParam, pageRequest);
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
	
	public Page<Comment> findByAll(SearchParam searchParam, PageRequest pageRequest) {
		String searchValue = "%"+ searchParam.getSearchValue() +"%";
		
		return dao.findByCommentLikeOrBoardSubjectLikeOrUserNameLike(searchValue, searchValue, searchValue, pageRequest);
	}
	
	public Page<Comment> findByComment(SearchParam searchParam, PageRequest pageRequest) {
		return dao.findByCommentLike("%"+ searchParam.getSearchValue() +"%", pageRequest);
	}
	
	public Page<Comment> findByBoardSubject(SearchParam searchParam, PageRequest pageRequest) {
		return dao.findByBoardSubjectLike("%"+ searchParam.getSearchValue() +"%", pageRequest);
	}
	
	public Page<Comment> findByUserName(SearchParam searchParam, PageRequest pageRequest) {
		return dao.findByUserNameLike("%"+ searchParam.getSearchValue() +"%", pageRequest);
	}
	
}
