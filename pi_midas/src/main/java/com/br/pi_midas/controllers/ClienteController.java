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

import com.br.pi_midas.dto.ClienteDTO;
import com.br.pi_midas.entity.Cliente;
import com.br.pi_midas.serivce.ClienteService;

@RestController
@RequestMapping(value ="/cliente")
public class ClienteController {


	@Autowired
	private ClienteService service;
	
	@GetMapping	
	public List<ClienteDTO> findAll(){
		return service.buscarTodosClientes();
	}
	
	@GetMapping(value = "/{id}")
	public ClienteDTO findById(@PathVariable Long id){
		return service.buscarUmCliente(id);
	}
	
	
	@PostMapping
	public ClienteDTO Insert(@RequestBody Cliente cliente){
		return service.cadastrarCliente(cliente);
	}
	
	@PutMapping(value = "/{id}")
	public ClienteDTO update(@PathVariable Long id, @RequestBody Cliente cliente) {
		return service.atualizarCliente(id,cliente);
	}
	

	@PutMapping(value = "/status/{id}")
	public ClienteDTO desativarAtivar(@PathVariable Long id,@RequestBody Cliente cliente) {
		return service.ativarDesativarCliente(id,cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Long id){
		return service.deletarCliente(id);
	}
}
