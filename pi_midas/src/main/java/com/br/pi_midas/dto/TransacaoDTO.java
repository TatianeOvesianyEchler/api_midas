package com.br.pi_midas.dto;

import com.br.pi_midas.Enum.Categoria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoDTO {

	private String nome;
	public Categoria categoria;
	private Long cliente_id;
	private String dataEntrada;
	public Double valor;

}
