package com.br.pi_midas.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pi_midas.entity.Transacao;
import com.br.pi_midas.repository.TransacaoRepository;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

	@Autowired
	private TransacaoRepository repository;
	
	@GetMapping	
	public List<Transacao> findAll(){
		List<Transacao> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Transacao findById(@PathVariable Long id){
		Transacao result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public Transacao Insert(@RequestBody Transacao transacao){
		Transacao result = repository.save(transacao);
		return result;
	}
	
	@PutMapping(value = "/{id}")
	public String update(@PathVariable Long id, @RequestBody Transacao transacao) {
		Transacao updateTransacao = repository.findById(id).get();
		updateTransacao.setNomeTransacao(transacao.getNomeTransacao());
		updateTransacao.setDataEntrada(transacao.getDataEntrada());
		updateTransacao.setValor(transacao.getValor());
		updateTransacao.setCategoria(transacao.getCategoria());
		repository.save(updateTransacao);
		return "Transacao Atualizada";
	}
	
	
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Long id){
		Transacao deleteResult = repository.findById(id).get();
		repository.delete(deleteResult);
		return "Deletada transação com Id : " + id;
	}
	
	
	
}
