package br.com.usuario.fallback;

import org.springframework.stereotype.Component;

import br.com.usuario.feign.CampanhaUsuarioClient;

@Component
public class CampanhaUsuarioFallback implements CampanhaUsuarioClient{

	@Override
	public boolean isCampanhaUsuario(Long idUsuario) {
		return false;
	}


	
}

