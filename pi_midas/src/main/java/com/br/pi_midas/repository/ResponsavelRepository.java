package com.br.pi_midas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.pi_midas.entity.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

	//@Query("SELECT u FROM User u WHERE u.userName =:userName")
	Responsavel findByResponsavel(String responsavel);
	
}