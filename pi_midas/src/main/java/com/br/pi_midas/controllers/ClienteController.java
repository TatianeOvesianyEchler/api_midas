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
	
	@PutMapping(value = "/{id}")
	public String update(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente updateCliente = repository.findById(id).get();
		updateCliente.setNome(cliente.getNome());
		updateCliente.setEmail(cliente.getEmail());
		updateCliente.setDataDeNascimento(cliente.getDataDeNascimento());
		updateCliente.setPerfil(cliente.getPerfil());
		updateCliente.setSenha(cliente.getSenha());
		
		repository.save(updateCliente);
		return "Cliente Atualizada";
	}
	
	@PutMapping(value = "/status/{id}")
	public String desativar(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente updatecliente = repository.findById(id).get();
		updatecliente.setStatus(cliente.getStatus());
		repository.save(updatecliente);
		if(cliente.getStatus() == Status.ATIVO) {			
			return "Cliente Ativo";
		}
		return "Cliente Inativo";
	}
	
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Long id){
		Cliente deleteResult = repository.findById(id).get();
		repository.delete(deleteResult);
		return "Deletado Cliente com Id : " + id;
	}
}
