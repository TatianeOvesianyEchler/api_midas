package com.br.pi_midas.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.pi_midas.entity.Carteira;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsavelDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String senha;
	
	
	private List<Carteira> carteiras;
	
}


