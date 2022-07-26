package com.br.pi_midas.dto;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.br.pi_midas.entity.Carteira;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsavelDTO {

	private String nome;
	private String email;
	private String senha;
	
	@OneToMany
	@JoinColumn(name = "responsavel_id") // Esta coluna está na tabela "carteira".
	private List<Carteira> carteiras;
	
}
