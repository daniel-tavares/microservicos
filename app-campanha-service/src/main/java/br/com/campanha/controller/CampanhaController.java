package br.com.campanha.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.campanha.model.Campanha;
import br.com.campanha.service.impl.CampanhaService;
import br.com.campanha.validation.ValidationAPI;

@RestController
@RequestMapping("/v1/campanhas")
public class CampanhaController {

	private static Logger log=LoggerFactory.getLogger(CampanhaController.class);
	
	@Autowired
	private CampanhaService campanhaService;
	
	
	
	@PostMapping
	public @ResponseBody ResponseEntity<Campanha> salvar(@Valid @RequestBody Campanha campanha){
		log.info("salvando campanha");
		return new ResponseEntity<>(campanhaService.salvar(campanha),HttpStatus.CREATED);
	}
	
	
	@PutMapping
	public  ResponseEntity<?> atualizar(@RequestBody Campanha campanha){
		Campanha campanhadb=campanhaService.buscarPorId(campanha.getId());
		ValidationAPI.validaCampanhaExiste(campanhadb,campanha.getId());
		return new ResponseEntity<>(campanhaService.salvar(campanha),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Long id){
		Campanha campanha=campanhaService.buscarPorId(id);
		ValidationAPI.validaCampanhaExiste(campanha,id);
		campanhaService.excluirPorId(id);
		return new ResponseEntity<>(campanha,HttpStatus.OK);
	}
	
	
	@GetMapping("/semAssociacaoUsuario/{idUsuario}/time/{idTime}")
	public ResponseEntity<List<Campanha>> buscarSemAssociacaoUsuario(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idTime") Long idTime ) {
		List<Campanha> campanhas=campanhaService.buscarSemAssociacaoUsuario(idUsuario,idTime);
		ValidationAPI.validaConsulta(campanhas, idUsuario);
		
		return new ResponseEntity<>(campanhas,HttpStatus.OK);
	}


	
	@GetMapping("/time/{idTime}")
	public  ResponseEntity<?> buscarCampanhasPorTime(@PathVariable("idTime") Long idTime){
		log.info("buscando campanhas pro time");
		List<Campanha> campanhas=campanhaService.buscarPorTime(idTime);
		ValidationAPI.validaConsulta(campanhas, idTime);
		return new ResponseEntity<>(campanhas,HttpStatus.OK);
	}

	
	@GetMapping
	public  ResponseEntity<?> buscarTodas(){
		log.info("buscando campanhas ativas");
		List<Campanha> campanhas=campanhaService.buscarTodas();
		ValidationAPI.validaConsulta(campanhas, null);
		return new ResponseEntity<>(campanhas,HttpStatus.OK);
	}
	
	@GetMapping("/ativas")
	public  ResponseEntity<?> buscarAtivas(){
		log.info("buscando campanhas ativas");
		List<Campanha> campanhas=campanhaService.buscarAtivas();
		ValidationAPI.validaConsulta(campanhas, null);
		return new ResponseEntity<>(campanhas,HttpStatus.OK);
	}

	
}
