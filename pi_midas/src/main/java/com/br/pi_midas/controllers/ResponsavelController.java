package com.br.pi_midas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pi_midas.dto.ResponsavelDTO;
import com.br.pi_midas.entity.Responsavel;
import com.br.pi_midas.service.ResponsavelService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RestController
@RequestMapping(value = "/responsavel")
public class ResponsavelController {
	
	@Autowired
	private ResponsavelService service;
	
	@GetMapping	
	public List<ResponsavelDTO> findAll(){
		return service.buscarTodosResponsaveis();
	}
	
	@GetMapping(value = "/{id}")
	public ResponsavelDTO findById(@PathVariable Long id){
		return service.buscarUmResponsavel(id);
	}
	
	@PostMapping
	public ResponsavelDTO Insert(@RequestBody Responsavel responsavel){
		return service.cadastrarResponsavel(responsavel);
	}

	@PutMapping(value = "/{id}")
	public ResponsavelDTO update(@PathVariable Long id, @RequestBody Responsavel responsavel) {
		return service.atualizarResponsavel(id,responsavel);
	}
	

	@PutMapping(value = "/status/{id}")
	public ResponsavelDTO desativarAtivar(@PathVariable Long id,@RequestBody Responsavel responsavel) {
		return service.ativarDesativarResponsavel(id,responsavel);
	}
	
	@DeleteMapping(value = "/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public String delete(@PathVariable Long id){
		return service.deletarResponsavel(id);
}
}