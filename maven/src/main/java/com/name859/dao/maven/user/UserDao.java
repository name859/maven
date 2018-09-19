package com.name859.dao.maven.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.name859.domain.maven.user.User;

public interface UserDao extends JpaRepository<User, Long> {

	Page<User> findByNameLike(String name, Pageable pageable);
	
	Page<User> findByVital(String vital, Pageable pageable);
	
	Page<User> findByVitalAndNameLike(String vital, String name, Pageable pageable);
	
}
