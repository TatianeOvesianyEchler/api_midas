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

import com.br.pi_midas.Enum.Status;
import com.br.pi_midas.entity.Carteira;
import com.br.pi_midas.repository.CarteiraRepository;


@RestController
@RequestMapping(value = "/carteira")
public class CarteiraController {
	
	@Autowired
	private CarteiraRepository repository;
	
	@GetMapping	
	public List<Carteira> findAll(){
		List<Carteira> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Carteira findById(@PathVariable Long id){
		Carteira result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public Carteira Insert(@RequestBody Carteira carteira){
		Carteira result = repository.save(carteira);
		return result;
	}

	@PutMapping(value = "/{id}")
	public String update(@PathVariable Long id, @RequestBody Carteira carteira) {
		Carteira updateCarteira = repository.findById(id).get();
		updateCarteira.setNome(carteira.getNome());
		updateCarteira.setResponsavel(carteira.getResponsavel());
		updateCarteira.setDataDeEntrada(carteira.getDataDeEntrada());
		repository.save(updateCarteira);
		return "Carteira Atualizada";
	}
	

	@PutMapping(value = "/status/{id}")
	public String desativar(@PathVariable Long id, @RequestBody Carteira carteira) {
		Carteira updateCarteira = repository.findById(id).get();
		updateCarteira.setStatus(carteira.getStatus());
		repository.save(updateCarteira);
		if(carteira.getStatus() == Status.ATIVO) {			
			return "Carteira Ativada";
		}
		return "Carteira Desativada";
	}
	
	
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Long id){
		Carteira deleteResult = repository.findById(id).get();
		repository.delete(deleteResult);
		return "Deletado Carteira com Id : " + id;
	}
	
		
	
}
	