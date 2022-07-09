package com.br.pi_midas.entity;

import java.util.Date;

public class Cliente {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Date DataDeNascimento;
	
	public Cliente() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataDeNascimento() {
		return DataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		DataDeNascimento = dataDeNascimento;
	}

}
