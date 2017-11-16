package br.com.usuario.service;

import br.com.usuario.model.Usuario;


public interface IUsuarioService extends JpaService<Usuario, Long> {
	
	Usuario buscarPorEmail(String email); 
}