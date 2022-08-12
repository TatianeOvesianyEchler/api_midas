package com.br.pi_midas.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_responsavel")
public class Responsavel implements Serializable {

	private static final long serialVersionUID = 1L;

	public Responsavel() {

	}

	public Responsavel(Long id, String nome, String email, String senha, List<Carteira> carteiras) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.carteiras = carteiras;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;

	@OneToMany
	@JoinColumn(name = "responsavel_id") // Esta coluna está na tabela "carteira".
	private List<Carteira> carteiras;

	
	
}
