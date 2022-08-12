package com.br.pi_midas.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pi_midas.dto.TransacaoDTO;
import com.br.pi_midas.entity.Transacao;
import com.br.pi_midas.service.TransacaoService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

	@Autowired
	private TransacaoService service;
	
	@GetMapping	
	public List<TransacaoDTO> findAll(){
		return	service.buscarTodasTransacoes();
	}
	
	@GetMapping(value = "/{id}")
	public TransacaoDTO findById(@PathVariable Long id){
		return	service.buscarUmaTransacao(id);
	}
	
	@PostMapping
	public TransacaoDTO Insert(@RequestBody Transacao transacao){
		return	service.cadastrarTransacao(transacao);
	}
	
	@PutMapping(value = "/{id}")
	public TransacaoDTO update(@PathVariable Long id, @RequestBody Transacao transacao) {
		return	service.atualizarTransacao(id, transacao);
	}
	
	
	@DeleteMapping(value = "/{id}")
	///@PreAuthorize("hasRole('ADMIN')")
	public String delete(@PathVariable Long id){
		return	service.deletarTranscao(id);
	}
	
	
	
}
