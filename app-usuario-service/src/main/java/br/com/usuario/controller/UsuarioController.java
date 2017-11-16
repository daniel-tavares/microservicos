package br.com.usuario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usuario.feign.CampanhaClient;
import br.com.usuario.feign.CampanhaUsuarioClient;
import br.com.usuario.model.Campanha;
import br.com.usuario.model.Usuario;
import br.com.usuario.service.impl.UsuarioService;
import br.com.usuario.validation.ValidationAPI;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController{

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	CampanhaClient campanhaClient;
	
	@Autowired
	CampanhaUsuarioClient campanhaUsuarioClient;
	
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Usuario usuario){
		Usuario usuariodb=usuarioService.buscarPorEmail(usuario.getEmail());
		
		if(isUsuarioCadastradoENaoPossuiCampanha(usuariodb,usuario.getId())) {
			List<Campanha>campanhasAtivas =buscarCampanhasAtivas();
			if(!campanhasAtivas.isEmpty())
			  return new ResponseEntity<>(campanhasAtivas, HttpStatus.OK);	
		}
		
		ValidationAPI.validaUsuarioCadastrado(usuariodb,null);
 		
		return new ResponseEntity<Usuario>(usuarioService.salvar(usuario), HttpStatus.CREATED);      	
	}
	
	
	private boolean isUsuarioCadastradoENaoPossuiCampanha(Usuario usuario,Long idUsuario) {
		return (usuario!=null && !isCampanha(usuario.getId()))?true:false;
	}
	
	private List<Campanha> buscarCampanhasAtivas() {
		return Optional.ofNullable(campanhaClient.buscarAtivas()).get();
		
	}
	
	private boolean isCampanha(Long idUsuario) {
		return campanhaUsuarioClient.isCampanhaUsuario(idUsuario);
	}
	
	
	
}
