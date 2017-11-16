package br.com.campanha.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.campanha.service.impl.CampanhaUsuarioService;
import br.com.campanha.vo.CampanhaUsuarioVO;

@RestController
@RequestMapping("/v1/campanhaUsuario")
public class CampanhaUsuarioController {

	private static Logger log=LoggerFactory.getLogger(CampanhaUsuarioController.class);
	
	@Autowired
	private CampanhaUsuarioService campanhaUsuarioService;
	
	@PostMapping("/associacao")
	public  ResponseEntity<CampanhaUsuarioVO> associar(@Valid @RequestBody CampanhaUsuarioVO campanhaClienteVO){
		log.info("vinculando campanhas ao usuario");
		return new ResponseEntity<CampanhaUsuarioVO>(campanhaUsuarioService.associar(campanhaClienteVO),HttpStatus.OK);
	}
	
	@GetMapping("/isCampanha/{id}")
	public boolean isCampanhaUsuario(@PathVariable("id") Long idUsuario) {
		log.info("consultando campanhas do usuario id:"+idUsuario);
		return campanhaUsuarioService.isCampanhaUsuario(idUsuario);
	}
	
}
