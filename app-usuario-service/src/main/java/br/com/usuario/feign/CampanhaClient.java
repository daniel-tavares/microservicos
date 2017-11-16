package br.com.usuario.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.usuario.fallback.CampanhaFallback;
import br.com.usuario.model.Campanha;

@FeignClient(name = "campanhaClient", url = "http://localhost:8000", fallback=CampanhaFallback.class)
public interface CampanhaClient {
	
	@RequestMapping(value="/api/v1/campanhas/ativas", method = RequestMethod.GET,consumes = "application/json")
    List<Campanha> buscarAtivas();
}

