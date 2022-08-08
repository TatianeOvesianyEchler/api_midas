package com.br.pi_midas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.pi_midas.Enum.Categoria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "tb_transacao")
public class Transacao {

	public Transacao() {

	}

	public Transacao(Long idTransacao, String nome, Categoria categoria, Long cliente_id, String dataEntrada,
			Double valor) {
		super();
		this.idTransacao = idTransacao;
		this.nome = nome;
		this.categoria = categoria;
		this.cliente_id = cliente_id;
		this.dataEntrada = dataEntrada;
		this.valor = valor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTransacao;
	private String nome;
	public Categoria categoria;
	private Long cliente_id;
	private String dataEntrada;
	public Double valor;

}
	