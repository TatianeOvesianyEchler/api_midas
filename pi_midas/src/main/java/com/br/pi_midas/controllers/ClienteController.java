package com.br.pi_midas.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pi_midas.entity.Carteira;
import com.br.pi_midas.entity.Cliente;
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
	
	
	@PostMapping
	public Cliente Insert(@RequestBody Cliente cliente){
		Cliente result = repository.save(cliente);
		return result;
	}
}
