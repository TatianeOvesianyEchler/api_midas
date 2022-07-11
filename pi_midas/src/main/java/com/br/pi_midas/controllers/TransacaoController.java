package com.br.pi_midas.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pi_midas.entity.Cliente;
import com.br.pi_midas.entity.Transacao;
import com.br.pi_midas.repository.ClienteRepository;
import com.br.pi_midas.repository.TransacaoRepository;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

	@Autowired
	private TransacaoRepository repository;
	private ClienteRepository Clienterepository;
	
	@GetMapping	
	public List<Transacao> findAll(){
		List<Transacao> result = repository.findAll();
		return result;
	}
	
	@PostMapping
	public Transacao Insert(@RequestBody Transacao transacao){
		Transacao result = repository.save(transacao);
		return result;
	}
	
	
}
