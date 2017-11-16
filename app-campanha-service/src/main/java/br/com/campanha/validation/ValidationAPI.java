package br.com.campanha.validation;

import java.util.List;

import br.com.campanha.exceptions.ResourceNotFoundException;
import br.com.campanha.model.Campanha;

public class ValidationAPI {


	public static void validaConsulta(List<Campanha> campanhas, Long id) {
		 if(campanhas.isEmpty())
				throw new ResourceNotFoundException(id,"Não foram encontrados registros para a consulta.");
	}
	
	
	public static void validaCampanhaExiste(Campanha campanha, Long id) {
		 if(campanha==null)
				throw new ResourceNotFoundException(id,"campanha informada não foi localizada.");
	}
	
	
	public static void validaCampanhaCadastrado(Campanha campanha, Long id) {
		 if(campanha!=null)
				throw new ResourceNotFoundException(id,"Campanha já existe no banco de dados.");
	}
}
