package br.com.usuario.validation;

import java.util.List;

import br.com.usuario.exceptions.ResourceNotFoundException;
import br.com.usuario.model.Usuario;

public class ValidationAPI {

	public static void validaConsulta(List<Usuario> usuarios, Long id) {
		 if(usuarios.isEmpty())
				throw new ResourceNotFoundException(id,"Não foram encontrados registros para a consulta.");
	}
	
	
	public static void validaUsuarioExiste(Usuario usuario, Long id) {
		 if(usuario==null)
				throw new ResourceNotFoundException(id,"Usuario informado não foi localizado.");
	}
	
	
	public static void validaUsuarioCadastrado(Usuario usuario, Long id) {
		 if(usuario!=null)
				throw new ResourceNotFoundException(id,"Usuário já existe no banco de dados.");
	}
}
