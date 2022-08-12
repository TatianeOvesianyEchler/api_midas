package com.br.pi_midas.dto;

import java.io.Serializable;
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
public class ClienteDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String senha;
	private String DataDeNascimento;
	private Perfil perfil;
	private Long carteira_id;
	private Status status;
	
	
	private List<Transacao> transacoes;
}
