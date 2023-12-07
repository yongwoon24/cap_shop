package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 @Query(value = "SELECT * FROM user WHERE id = :id ", nativeQuery = true)
	    List<User> findById(String id);
	 
	 @Query(value = "SELECT * FROM user WHERE id = :id ", nativeQuery = true)
	   User findById1(String id);
}
