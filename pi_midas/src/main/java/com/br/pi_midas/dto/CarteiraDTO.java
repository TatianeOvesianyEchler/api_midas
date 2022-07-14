package com.br.pi_midas.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.br.pi_midas.Enum.Status;
import com.br.pi_midas.entity.Cliente;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter

public class CarteiraDTO {

	
	private String nome;
	private String dataDeEntrada;
	private String responsavel;
	private Status status;
	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "carteira_id") // Esta coluna está na tabela "cliente".
	private List<Cliente> clientes;

}
