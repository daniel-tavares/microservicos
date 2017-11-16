package br.com.campanha.service.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.campanha.AppCampanhaServiceApplication;
import br.com.campanha.model.Campanha;
import br.com.campanha.notificacao.CampanhaNotificador;
import br.com.campanha.repository.CampanhaRepository;
import br.com.campanha.service.ICampanhaService;

@Service
public class CampanhaService implements ICampanhaService {

	@Autowired
	CampanhaRepository repository;

	@Autowired
	CampanhaNotificador campanhaNotificador;
	
	public List<Campanha> buscarAtivas() {
		return repository.buscarAtivas(LocalDate.now());
	}

	public Campanha buscarPorId(Long id) {
		return repository.findOne(id);
	}

	public Campanha salvar(Campanha campanha){
		validarCampanhasVigentesExistentesParaPeriodo(campanha);
		Campanha campanhaDb = repository.save(campanha);
		try {
			campanhaNotificador.notificarCadastro(campanhaDb);
		} catch (AmqpException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return campanhaDb;
	}
	
	@Override
	public void excluirPorId(Long id) {
		repository.delete(id);
	}


	@Override
	public List<Campanha> buscarPorTime(Long id) {
		return repository.buscarPorTime(id);
	}
	
	private void validarCampanhasVigentesExistentesParaPeriodo(Campanha novaCampanha){

		List<Campanha> campanhasExistentes = repository.buscarAtivasParaPeriodo(novaCampanha.getDataFimVigencia());

		campanhasExistentes
				.stream().map(p -> incrementaDataFinalVigencia(p,
						campanhasExistentes.subList(1, campanhasExistentes.size()), novaCampanha))
				.collect(Collectors.toList());

		repository.save(campanhasExistentes);
		
		try {
			campanhaNotificador.notificarAlteracoes(campanhasExistentes);
		} catch (AmqpException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}

	private Campanha incrementaDataFinalVigencia(Campanha campanha, List<Campanha> campanhasVigentes,
			Campanha novaCampanha){
		campanha.setDataFimVigencia(campanha.getDataFimVigencia().plusDays(1));
		validarCampanhasVigentesExistentesParaPeriodo(campanha);
		return campanha;
	}

	@Override
	public List<Campanha> buscarSemAssociacaoUsuario(Long idUsuario,Long idTime) {
	   return repository.buscarSemAssociacaoUsuario(idUsuario, idTime, LocalDate.now());
	}

	@Override
	public List<Campanha> buscarTodas() {
		return repository.buscarTodas();
	}

	
}
