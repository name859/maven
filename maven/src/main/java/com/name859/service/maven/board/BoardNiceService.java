package com.name859.service.maven.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;
import com.name859.dao.maven.board.BoardNiceDao;
import com.name859.domain.maven.board.BoardNice;
import com.name859.service.GeneralServiceImpl;

@Service
@Transactional
public class BoardNiceService extends GeneralServiceImpl<BoardNice, BoardNiceDao, PageParam, SearchParam> {

	@Override
	public Page<BoardNice> findAll(PageParam pageParam, SearchParam searchParam) {
		PageRequest pageRequest = new PageRequest(pageParam.getCurrentPage(), pageParam.getViewRecord(), new Sort(Direction.DESC, searchParam.getOrderBy()));
		
		Page<BoardNice> result = null;
		if (searchParam.isSearch()) {
			switch(searchParam.getSearchOption()) {
			case 1 :
				result = findByBoardId(searchParam, pageRequest);
				break;
			case 2 :
				result = findByBoardIdAndVital(searchParam, pageRequest);
			}
		} else {
			result = dao.findAll(pageRequest);
		}
		if (result == null) throw new NullPointerException();
		
		return result;
	}
	
	public Page<BoardNice> findByBoardId(SearchParam searchParam, PageRequest pageRequest) {
		return dao.findByBoardBoardId(Long.parseLong(searchParam.getSearchValue()), pageRequest);
	}
	
	public Page<BoardNice> findByBoardIdAndVital(SearchParam searchParam, PageRequest pageRequest) {
		return dao.findByBoardBoardIdAndVital(Long.parseLong(searchParam.getSearchValue().split(",")[0]), searchParam.getSearchValue().split(",")[1], pageRequest);
	}
	
	public BoardNice nice(BoardNice model) {
		BoardNice boardNice = findByBoardIdAndUserId(model.board.getBoardId(), model.user.getUserId());
		if (boardNice == null) {
			return this.add(model);
		} else {
			if (boardNice.getVital().equals("Y")) {
				boardNice.setVital("N");
			} else {
				boardNice.setVital("Y");
			}
			return this.modify(boardNice);
		}
	}
	
	public BoardNice findByBoardIdAndUserId(Long boardId, Long userId) {
		return dao.findByBoardBoardIdAndUserUserId(boardId, userId);
	}
	
}
