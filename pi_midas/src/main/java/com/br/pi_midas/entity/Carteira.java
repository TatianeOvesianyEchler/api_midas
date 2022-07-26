package com.br.pi_midas.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.pi_midas.Enum.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_carteira")
public class Carteira {

	public Carteira() {

	}


	public Carteira(Long idCarteira, String nome, String dataDeEntrada, Long responsavel_id, Status status,
			List<Cliente> clientes) {
		
		this.idCarteira = idCarteira;
		this.nome = nome;
		this.dataDeEntrada = dataDeEntrada;
		this.responsavel_id = responsavel_id;
		this.status = status;
		this.clientes = clientes;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarteira;
	private String nome;
	private String dataDeEntrada;
	

	@Column(nullable = false)
	private Status status;
	private Long responsavel_id;
	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "carteira_id") // Esta coluna está na tabela "cliente".
	private List<Cliente> clientes;

}
