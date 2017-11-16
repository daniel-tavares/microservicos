package br.com.usuario.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.usuario.fallback.CampanhaUsuarioFallback;

@FeignClient(name = "campanhaUsuarioClient", url = "http://localhost:8000" ,fallback=CampanhaUsuarioFallback.class)
public interface CampanhaUsuarioClient {
	
	@RequestMapping(value="/api/v1/campanhaUsuario/isCampanha/{idUsuario}", method = RequestMethod.GET, consumes = "application/json")
    boolean isCampanhaUsuario(@PathVariable("idUsuario") Long idUsuario);
	
}
