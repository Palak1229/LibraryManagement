package com.library.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.management.entity.Member;

import jakarta.persistence.Id;

public interface MemberRepo extends JpaRepository<Member, Integer>{
	

}
