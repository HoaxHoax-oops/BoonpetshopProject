package com.boonpetshop.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.boonpetshop.entity.Role;

@Repository
public interface RoleRepository extends JpaRepositoryImplementation<Role, Integer>{

}
