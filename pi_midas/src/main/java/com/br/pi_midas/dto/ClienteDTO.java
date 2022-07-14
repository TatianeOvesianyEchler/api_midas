package com.br.pi_midas.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.br.pi_midas.Enum.Perfil;
import com.br.pi_midas.Enum.Status;
import com.br.pi_midas.entity.Transacao;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ClienteDTO {

	private String nome;
	private String email;
	private String senha;
	private String DataDeNascimento;
	private Perfil perfil;
	private Long cliente_id;
	private Status status;
	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "cliente_id") // Esta coluna está na tabela "transacao".
	private List<Transacao> transacoes;
}
