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

import com.br.pi_midas.dto.CarteiraDTO;
import com.br.pi_midas.entity.Carteira;
import com.br.pi_midas.serivce.CarteiraService;


@RestController
@RequestMapping(value = "/carteira")
public class CarteiraController {
	
	@Autowired
	private CarteiraService service;
	
	
	@GetMapping	
	public List<CarteiraDTO> todasCarteiras(){
		return	service.buscarTodasCarteiras();
	}
	
	
	@GetMapping(value = "/{id}")
	public CarteiraDTO findById(@PathVariable Long id){
		return service.buscarUmaCarteira(id);
	}
	
	@PostMapping
	public CarteiraDTO Insert(@RequestBody Carteira carteira){
		return  service.cadastrarCarteira(carteira);
	}

	@PutMapping(value = "/{id}")
	public CarteiraDTO update(@PathVariable Long id,@RequestBody Carteira carteira) {
		return service.atualizarCarteira(id,carteira);
	}
	

	@PutMapping(value = "/status/{id}")
	public CarteiraDTO desativarAtivar(@PathVariable Long id,@RequestBody Carteira carteira) {
		return service.ativarDesativarCarteira(id,carteira);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Long id){
		return service.deletarCarteira(id);
	}

}
	