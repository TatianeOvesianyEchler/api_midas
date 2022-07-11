package com.br.pi_midas.entity;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "tb_carteira")
public class Carteira {

	public Carteira() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarteira;
	private String nome;
	private String dataDeEntrada;
	private String responsavel;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "cliente_id") // Esta coluna está na tabela "cliente".
	private List<Cliente> clientes;

}
