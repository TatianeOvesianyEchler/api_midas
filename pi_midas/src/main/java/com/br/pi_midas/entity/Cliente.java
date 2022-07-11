package com.br.pi_midas.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.pi_midas.Enum.Perfil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	public Cliente() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String DataDeNascimento;
	private Perfil perfil;
	private Long cliente_id;
	
	
	@OneToMany
	@JoinColumn(name = "cliente_id") // Esta coluna está na tabela "transacao".
	private List<Transacao> transacoes;

}
