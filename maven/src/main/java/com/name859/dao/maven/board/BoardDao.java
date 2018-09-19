package com.name859.dao.maven.board;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.name859.domain.maven.board.Board;

public interface BoardDao extends JpaRepository<Board, Long> {

//	@Query(value = "select b from Board b order by group_id asc, sequence asc")
//	List<Board> queryFindAll();
//	
//	Page<Board> findByBoardIdNotNullOrderByGroupIdAscSequenceAsc(Pageable pageable);
	
	@Query(value = "select b from Board b order by group_id desc, sequence asc")
	List<Board> queryFindAll();
	
	Page<Board> findByBoardIdNotNullOrderByGroupIdDescSequenceAsc(Pageable pageable);
	
	Page<Board> findBySubjectLikeOrContentLikeOrUserNameLike(String subject, String content, String userName, Pageable pageable);
	
	Page<Board> findBySubjectLike(String subject, Pageable pageable);
	
	Page<Board> findByContentLike(String content, Pageable pageable);
	
	Page<Board> findByUserNameLike(String userName, Pageable pageable);
	
	@Query(value = "select b from Board b where group_id = :groupId and sequence > :sequence and level <= :level order by sequence asc")
	List<Board> queryFindX(@Param("groupId") Long groupId, @Param("sequence") int sequence, @Param("level") int level);
	
	List<Board> findByGroupIdAndSequenceGreaterThanAndLevelLessThanEqualOrderBySequenceAsc(Long groupId, int sequence, int level);
	
	@Query(value = "select b from Board b where group_id = :groupId and sequence > :sequence and level > :level order by sequence desc")
	List<Board> queryFindY(@Param("groupId") Long groupId, @Param("sequence") int sequence, @Param("level") int level);
	
	List<Board> findByGroupIdAndSequenceGreaterThanAndLevelGreaterThanOrderBySequenceDesc(Long groupId, int sequence, int level);
	
	@Query(value = "select b from Board b where group_id = :groupId and sequence > :sequence and sequence < :x and level > :level order by sequence desc")
	List<Board> queryFindY(@Param("groupId") Long groupId, @Param("sequence") int sequence, @Param("x") int x, @Param("level") int level);
	
	@Query(value = "UPDATE board SET sequence = sequence + 1 WHERE group_id = :groupId AND sequence > :sequence", nativeQuery = true)
	List<Board> queryUpdate(@Param("groupId") Long groupId, @Param("sequence") int sequence);
	
	@Query(value = "DELETE FROM board WHERE group_id = :groupId AND sequence >= :sequence", nativeQuery = true)
	List<Board> queryDelete(@Param("groupId") Long groupId, @Param("sequence") int sequence);
	
	List<Board> deleteByGroupIdAndSequenceGreaterThanEqual(Long groupId, int sequence);
	
	@Query(value = "DELETE FROM board WHERE group_id = :groupId AND sequence >= :sequence AND sequence < :x", nativeQuery = true)
	List<Board> queryDelete(@Param("groupId") Long groupId, @Param("sequence") int sequence, @Param("x") int x);
	
}
