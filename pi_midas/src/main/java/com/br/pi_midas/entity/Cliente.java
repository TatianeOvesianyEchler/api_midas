package com.br.pi_midas.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.pi_midas.Enum.Perfil;
import com.br.pi_midas.Enum.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable{

	
	private static final long serialVersionUID = 1L;

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
	private Long carteira_id;
	private Status status;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "cliente_id") // Esta coluna está na tabela "transacao".
	private List<Transacao> transacoes;

}
