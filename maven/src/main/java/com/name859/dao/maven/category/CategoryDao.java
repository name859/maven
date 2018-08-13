package com.name859.dao.maven.category;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.name859.domain.maven.category.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

//	@Query(value = "SELECT * FROM category WHERE user_id = :userId ORDER BY group_id DESC, sequence ASC", nativeQuery = true)
//	List<Category> queryFindByUserId(@Param("userId") Long userId);
	
	@Query(value = "SELECT * FROM category WHERE user_id = :userId ORDER BY group_id ASC, sequence ASC", nativeQuery = true)
	List<Category> queryFindByUserId(@Param("userId") Long userId);
	
	@Query(value = "SELECT sequence FROM category WHERE group_id = :groupId AND sequence > :sequence AND level <= :level ORDER BY sequence ASC", nativeQuery = true)
	List<Integer> queryFindX(@Param("groupId") Long groupId, @Param("sequence") int sequence, @Param("level") int level);
	
	@Query(value = "SELECT sequence FROM category WHERE group_id = :groupId AND sequence > :sequence AND level > :level ORDER BY sequence DESC", nativeQuery = true)
	List<Integer> queryFindY(@Param("groupId") Long groupId, @Param("sequence") int sequence, @Param("level") int level);
	
	@Query(value = "SELECT sequence FROM category WHERE group_id = :groupId AND sequence > :sequence AND sequence < :x AND level > :level ORDER BY sequence DESC", nativeQuery = true)
	List<Integer> queryFindY(@Param("groupId") Long groupId, @Param("sequence") int sequence, @Param("x") int x, @Param("level") int level);
	
	@Query(value = "UPDATE category SET sequence = sequence + 1 WHERE group_id = :groupId AND sequence > :sequence", nativeQuery = true)
	List<Category> queryUpdate(@Param("groupId") Long groupId, @Param("sequence") int sequence);
	
	@Query(value = "DELETE FROM category WHERE group_id = :groupId AND sequence >= :sequence", nativeQuery = true)
	List<Category> queryDelete(@Param("groupId") Long groupId, @Param("sequence") int sequence);
	
	@Query(value = "DELETE FROM category WHERE group_id = :groupId AND sequence >= :sequence AND sequence < :x", nativeQuery = true)
	List<Category> queryDelete(@Param("groupId") Long groupId, @Param("sequence") int sequence, @Param("x") int x);
	
	Page<Category> findByNameLike(String name, Pageable pageable);
	
	Page<Category> findByNoteLike(String note, Pageable pageable);
	
}
