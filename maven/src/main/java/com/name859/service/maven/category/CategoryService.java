package com.name859.service.maven.category;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;
import com.name859.dao.maven.category.CategoryDao;
import com.name859.domain.maven.category.Category;
import com.name859.service.GeneralServiceImpl;

@Service
@Transactional
public class CategoryService extends GeneralServiceImpl<Category, CategoryDao, PageParam, SearchParam> {

//	@Override
//	public Category add(Category domain) {
//		if (domain.getLevel() == 1) {
//			domain.setGroupId(dao.save(domain).getCategoryId());
//		} else {
//			dao.queryUpdate(domain.getGroupId(), domain.getSequence() - 1);
//		}
//		
//		return super.add(domain);
//	}
	
	@Override
	public Category add(Category domain) {
		if (domain.getLevel() == 1) {
			domain.setGroupId(dao.save(domain).getCategoryId());
		} else {
			List<Integer> list = dao.queryFindX(domain.getGroupId(), domain.getSequence() - 1, domain.getLevel() - 1);
			
			if (list.size() == 0) {
				list = dao.queryFindY(domain.getGroupId(), domain.getSequence() - 1, domain.getLevel() - 1);
			} else {
				list = dao.queryFindY(domain.getGroupId(), domain.getSequence() - 1, list.get(0), domain.getLevel() - 1);
			}
			
			if (list.size() == 0) {
				dao.queryUpdate(domain.getGroupId(), domain.getSequence() - 1);
			} else {
				dao.queryUpdate(domain.getGroupId(), list.get(0));
				
				domain.setSequence(list.get(0) + 1);
			}
		}
		
		return super.add(domain);
	}
	
	@Override
	public void deleteById(Long domainId) {
		Category category = dao.findOne(domainId);
		
		List<Integer> list = dao.queryFindX(category.getGroupId(), category.getSequence(), category.getLevel());
		if (list.size() == 0) {
			dao.queryDelete(category.getGroupId(), category.getSequence());
		} else {
			dao.queryDelete(category.getGroupId(), category.getSequence(), list.get(0));
		}
	}
	
	public List<Category> findByUserId(Long userId) {
		return dao.queryFindByUserId(userId);
	}
	
}
