package com.hashirama.AshBackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashirama.AshBackend.entity.usercr;


public interface RuserRepository extends JpaRepository<usercr,String> {
	
	Optional<usercr> findByEmail(String email);
	boolean existsByEmail(String email);
}
