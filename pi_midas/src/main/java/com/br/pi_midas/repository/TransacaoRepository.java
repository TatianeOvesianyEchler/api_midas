package com.br.pi_midas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pi_midas.entity.Transacao;



public interface TransacaoRepository extends JpaRepository <Transacao,Long>{

}
