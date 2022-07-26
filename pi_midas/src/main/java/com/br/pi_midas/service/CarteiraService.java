package com.br.pi_midas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pi_midas.dto.CarteiraDTO;
import com.br.pi_midas.entity.Carteira;
import com.br.pi_midas.repository.CarteiraRepository;

@Service
public class CarteiraService {
	
	@Autowired(required = false)
	private ModelMapper modelMapper;
	@Autowired
	private CarteiraRepository repository;

	public List<CarteiraDTO> buscarTodasCarteiras() {
		return	repository.findAll()
				.stream()
				.map(this::toCarteiraDTO)
				.collect(Collectors.toList());

	}
	
	public CarteiraDTO buscarUmaCarteira(Long id) {
		Carteira carteira = repository.findById(id).orElseThrow();
		return toCarteiraDTO(carteira);
	}
	
	public CarteiraDTO cadastrarCarteira(Carteira carteira) {
		Carteira result = repository.save(carteira);
		return toCarteiraDTO(result);
	}
	
	public CarteiraDTO atualizarCarteira(Long id,Carteira carteira) {
		Carteira updateCarteira = repository.findById(id).get();
		updateCarteira.setNome(carteira.getNome());
		updateCarteira.setResponsavel_id(carteira.getResponsavel_id());
		updateCarteira.setDataDeEntrada(carteira.getDataDeEntrada());
		repository.save(updateCarteira);
		return toCarteiraDTO(updateCarteira);
	}
	
	public CarteiraDTO ativarDesativarCarteira(Long id,Carteira carteira) {
		Carteira updateStatus = repository.findById(id).get();
		updateStatus.setStatus(carteira.getStatus()); 
		repository.save(updateStatus);
		return toCarteiraDTO(updateStatus);
	}
	
	public String deletarCarteira(Long id) {
		Carteira deleteResult = repository.findById(id).get();
		repository.delete(deleteResult);
		return "Deletado Carteira com Id : " + id;
	}


	private CarteiraDTO toCarteiraDTO(Carteira carteira) {
		return modelMapper.map(carteira, CarteiraDTO.class);
	}
}
