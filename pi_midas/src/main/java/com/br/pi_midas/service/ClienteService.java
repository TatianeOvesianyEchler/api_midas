package com.br.pi_midas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pi_midas.dto.ClienteDTO;
import com.br.pi_midas.entity.Cliente;
import com.br.pi_midas.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired(required = false)
	private ModelMapper modelMapper;
	@Autowired
	private ClienteRepository repository;

	public List<ClienteDTO> buscarTodosClientes() {
		return	repository.findAll()
				.stream()
				.map(this::toClienteDTO)
				.collect(Collectors.toList());
	}
	
	public ClienteDTO buscarUmCliente(Long id) {
		Cliente cliente = repository.findById(id).orElseThrow();
		return toClienteDTO(cliente);
	}
	
	public ClienteDTO cadastrarCliente(Cliente cliente) {
		Cliente result = repository.save(cliente);
		return toClienteDTO(result);
	}
	
	public ClienteDTO atualizarCliente(Long id,Cliente cliente) {
		Cliente updateCliente = repository.findById(id).get();
		updateCliente.setNome(cliente.getNome());
		updateCliente.setEmail(cliente.getEmail());
		updateCliente.setSenha(cliente.getSenha());
		updateCliente.setDataDeNascimento(cliente.getDataDeNascimento());
		updateCliente.setPerfil(cliente.getPerfil());
		updateCliente.setCarteira_id(cliente.getCarteira_id());
		updateCliente.setStatus(cliente.getStatus());
		updateCliente.setTransacoes(cliente.getTransacoes());
		repository.save(updateCliente);
		return toClienteDTO(updateCliente);
	}
	
	public ClienteDTO ativarDesativarCliente(Long id,Cliente cliente) {
		Cliente updateStatus = repository.findById(id).get();
		updateStatus.setStatus(cliente.getStatus()); 
		repository.save(updateStatus);
		return toClienteDTO(updateStatus);
	}
	
	public String deletarCliente(Long id) {
		Cliente deleteCliente = repository.findById(id).get();
		repository.delete(deleteCliente);
		return "Deletado Cliente com Id : " + id;
	}


	private ClienteDTO toClienteDTO(Cliente cliente) {
		return modelMapper.map(cliente, ClienteDTO.class);
	}
}

