package com.br.pi_midas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
	
}
