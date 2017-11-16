package br.com.usuario.service;

import br.com.usuario.model.Usuario;

public interface JpaService<T, ID> {
	
	Usuario salvar(T entity);
	
	Usuario buscarPorId(Long id);
}