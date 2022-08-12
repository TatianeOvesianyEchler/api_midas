package com.br.pi_midas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.pi_midas.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//@Query("SELECT u FROM User u WHERE u.userName =:userName")
	User findByUserName(String userName);
	
}