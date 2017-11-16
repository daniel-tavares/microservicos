package br.com.usuario.fallback;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.usuario.feign.CampanhaClient;
import br.com.usuario.model.Campanha;

@Component
public class CampanhaFallback implements CampanhaClient{

	@Override
	public List<Campanha> buscarAtivas() {
	    return Arrays.asList();
	}
	
}

