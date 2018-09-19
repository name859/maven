package com.name859.service.maven.board;

import java.util.List;

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
			result = findAll(pageRequest);
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
	
	public Page<Board> findAll(PageRequest pageRequest) {
		return dao.findByBoardIdNotNullOrderByGroupIdDescSequenceAsc(pageRequest);
	}
	
//	@Override
//	public Board add(Board domain) {
//		if (domain.getLevel() == 1) {
//			domain.setGroupId(dao.save(domain).getBoardId());
//		} else {
//			List<Board> list = findX(domain.getGroupId(), domain.getSequence() - 1, domain.getLevel() - 1);
//			
//			if (list.size() == 0) {
//				list = findY(domain.getGroupId(), domain.getSequence() - 1, domain.getLevel() - 1);
//			} else {
//				list = findY(domain.getGroupId(), domain.getSequence() - 1, list.get(0).getSequence(), domain.getLevel() - 1);
//			}
//			
//			if (list.size() == 0) {
//				update(domain.getGroupId(), domain.getSequence() - 1);
//			} else {
//				update(domain.getGroupId(), list.get(0).getSequence());
//				
//				domain.setSequence(list.get(0).getSequence() + 1);
//			}
//		}
//		
//		return super.add(domain);
//	}
	
	@Override
	public Board add(Board domain) {
		if (domain.getLevel() == 1) {
			domain.setGroupId(dao.save(domain).getBoardId());
		} else {
			update(domain.getGroupId(), domain.getSequence() - 1);
		}
		
		return super.add(domain);
	}
	
	@Override
	public void deleteById(Long domainId) {
		Board domain = dao.findOne(domainId);
		
		List<Board> list = findX(domain.getGroupId(), domain.getSequence(), domain.getLevel());
		if (list.size() == 0) {
			delete(domain.getGroupId(), domain.getSequence());
		} else {
			delete(domain.getGroupId(), domain.getSequence(), list.get(0).getSequence());
		}
	}
	
	public List<Board> findX(Long groupId, int sequence, int level) {
		return dao.findByGroupIdAndSequenceGreaterThanAndLevelLessThanEqualOrderBySequenceAsc(groupId, sequence, level);
	}
	
	public List<Board> findY(Long groupId, int sequence, int level) {
		return dao.findByGroupIdAndSequenceGreaterThanAndLevelGreaterThanOrderBySequenceDesc(groupId, sequence, level);
	}
	
	public List<Board> findY(Long groupId, int sequence, int x, int level) {
		return dao.queryFindY(groupId, sequence, x, level);
	}
	
	public List<Board> update(Long groupId, int sequence) {
		return dao.queryUpdate(groupId, sequence);
	}
	
	public List<Board> delete(Long groupId, int sequence) {
		return dao.deleteByGroupIdAndSequenceGreaterThanEqual(groupId, sequence);
	}
	
	public List<Board> delete(Long groupId, int sequence, int x) {
		return dao.queryDelete(groupId, sequence, x);
	}
	
}
