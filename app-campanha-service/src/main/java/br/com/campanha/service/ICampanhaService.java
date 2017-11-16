package br.com.campanha.service;

import java.util.List;

import br.com.campanha.model.Campanha;


public interface ICampanhaService{
	
	List<Campanha> buscarTodas();
	
	List<Campanha> buscarAtivas();
	
	List<Campanha> buscarPorTime(Long id);
	
	List<Campanha> buscarSemAssociacaoUsuario(Long id, Long idTime);
	
	void excluirPorId(Long id);
	
	
}