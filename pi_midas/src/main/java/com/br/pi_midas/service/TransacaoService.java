package com.br.pi_midas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pi_midas.dto.TransacaoDTO;
import com.br.pi_midas.entity.Transacao;
import com.br.pi_midas.repository.TransacaoRepository;


@Service
public class TransacaoService {
	
	@Autowired(required = false)
	private ModelMapper modelMapper;
	@Autowired
	private TransacaoRepository repository;

	public List<TransacaoDTO> buscarTodasTransacoes() {
		return	repository.findAll()
				.stream()
				.map(this::toTransacaoDTO)
				.collect(Collectors.toList());
	}
	
	public TransacaoDTO buscarUmaTransacao(Long id) {
		Transacao transacao = repository.findById(id).orElseThrow();
		return toTransacaoDTO(transacao);
	}
	
	public TransacaoDTO cadastrarTransacao(Transacao transacao) {
		Transacao result = repository.save(transacao);
		return toTransacaoDTO(result);
	}
	
	public TransacaoDTO atualizarTransacao(Long id,Transacao transacao) {
		Transacao updateTransacao = repository.findById(id).get();
		updateTransacao.setNome(transacao.getNome());
		updateTransacao.setCategoria(transacao.getCategoria());
		updateTransacao.setCliente_id(transacao.getCliente_id());
		updateTransacao.setDataEntrada(transacao.getDataEntrada());
		updateTransacao.setValor(transacao.getValor());
		repository.save(updateTransacao);
		return toTransacaoDTO(updateTransacao);
	}
	
	
	public String deletarTranscao(Long id) {
		Transacao deleteTransacao = repository.findById(id).get();
		repository.delete(deleteTransacao);
		return "Deletado Transação com Id : " + id;
	}


	private TransacaoDTO toTransacaoDTO(Transacao transacao) {
		return modelMapper.map(transacao, TransacaoDTO.class);
	}
}
