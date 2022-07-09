package com.br.pi_midas.entity;

import java.util.Date;

public class Carteira {

	private Long idEntrada;
	private Date DataDeEntrada;
	private String cliente;
	private String idTransacao;
	private Double valor;
	
	
	public Carteira() {
		
	}


	public Long getIdEntrada() {
		return idEntrada;
	}


	public void setIdEntrada(Long idEntrada) {
		this.idEntrada = idEntrada;
	}


	public Date getDataDeEntrada() {
		return DataDeEntrada;
	}


	public void setDataDeEntrada(Date dataDeEntrada) {
		DataDeEntrada = dataDeEntrada;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getIdTransacao() {
		return idTransacao;
	}


	public void setIdTransacao(String idTransacao) {
		this.idTransacao = idTransacao;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}
}
