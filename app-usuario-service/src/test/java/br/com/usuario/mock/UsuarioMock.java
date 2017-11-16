package br.com.usuario.mock;

import java.time.LocalDate;

import br.com.usuario.enums.SituacaoAtivoInativoEnum;
import br.com.usuario.model.Usuario;

public class UsuarioMock {

	public static Usuario getNovoUsuario() {
		Usuario usuario=new Usuario();
		usuario.setIdTime(1l);
		usuario.setEmail("danieltavares.web@gmail.com");
		usuario.setNome("Daniel Tavares");
		usuario.setDataNascimento(LocalDate.of(1983, 10, 07));
     
		return usuario;
	}
	
	
	
	public static Usuario getUsuarioSalvo() {
		Usuario usuario=new Usuario();
		usuario.setId(1l);
		usuario.setIdTime(1l);
		usuario.setEmail("danieltavares.web@gmail.com");
		usuario.setNome("Daniel Tavares");
		usuario.setDataNascimento(LocalDate.of(1983, 10, 07));
        usuario.setSituacao(SituacaoAtivoInativoEnum.ATIVO);
        
		return usuario;
	}
}
