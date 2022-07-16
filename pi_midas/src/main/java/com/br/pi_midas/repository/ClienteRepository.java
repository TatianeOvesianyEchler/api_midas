package com.br.pi_midas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pi_midas.entity.Cliente;


public interface ClienteRepository extends JpaRepository <Cliente,Long>{

}
