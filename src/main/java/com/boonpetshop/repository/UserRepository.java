package com.boonpetshop.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import com.boonpetshop.entity.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Integer>{
	@Query("SELECT u FROM User u WHERE u.email = :email")
	public User findByEmail(@Param("email") String email);
}
