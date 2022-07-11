package com.br.pi_midas.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pi_midas.entity.Carteira;
import com.br.pi_midas.entity.Cliente;
import com.br.pi_midas.entity.Transacao;
import com.br.pi_midas.repository.ClienteRepository;

@RestController
@RequestMapping(value ="/cliente")
public class ClienteController {


	@Autowired
	private ClienteRepository repository;
	
	@GetMapping	
	public List<Cliente> findAll(){
		List<Cliente> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Cliente findById(@PathVariable Long id){
		Cliente result = repository.findById(id).get();
		return result;
	}
	
	
	@PostMapping
	public Cliente Insert(@RequestBody Cliente cliente){
		Cliente result = repository.save(cliente);
		return result;
	}
	
	
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Long id){
		Cliente deleteResult = repository.findById(id).get();
		repository.delete(deleteResult);
		return "Deletado Cliente com Id : " + id;
	}
}
