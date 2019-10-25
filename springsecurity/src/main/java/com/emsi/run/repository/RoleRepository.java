package com.emsi.run.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsi.run.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
