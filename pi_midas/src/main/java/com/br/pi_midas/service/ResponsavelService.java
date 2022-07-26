package com.br.pi_midas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pi_midas.dto.ResponsavelDTO;
import com.br.pi_midas.entity.Responsavel;
import com.br.pi_midas.repository.ResponsavelRepository;

@Service
public class ResponsavelService {

	@Autowired(required = false)
	private ModelMapper modelMapper;
	@Autowired
	private ResponsavelRepository repository;
	
	public List<ResponsavelDTO> buscarTodosResponsaveis(){
		return repository.findAll()
				.stream()
				.map(this::toResponsavelDTO)
				.collect(Collectors.toList());
	}
	
	public ResponsavelDTO buscarUmResponsavel(Long id) {
		Responsavel responsavel = repository.findById(id).orElseThrow();
		return toResponsavelDTO(responsavel);
	}
	
	public ResponsavelDTO cadastrarResponsavel(Responsavel responsavel) {
		Responsavel result = repository.save(responsavel);
		return toResponsavelDTO(result);
	}
	
	public ResponsavelDTO atualizarResponsavel(Long id,Responsavel responsavel) {
		Responsavel updateResponsavel = repository.findById(id).get();
		updateResponsavel.setNome(responsavel.getNome());
		repository.save(updateResponsavel);
		return toResponsavelDTO(updateResponsavel);
	}
	
	public ResponsavelDTO ativarDesativarResponsavel(Long id,Responsavel responsavel) {
		Responsavel updateStatus = repository.findById(id).get();
		repository.save(updateStatus);
		return toResponsavelDTO(updateStatus);
	}
	
	public String deletarResponsavel(Long id) {
		Responsavel deleteResult = repository.findById(id).get();
		repository.delete(deleteResult);
		return "Deletado Responsavel com Id : " + id;
	}


	private ResponsavelDTO toResponsavelDTO(Responsavel responsavel) {
		return modelMapper.map(responsavel, ResponsavelDTO.class);
	}
}

	
	
	
	
	

