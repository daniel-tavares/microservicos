package br.com.usuario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usuario.model.Usuario;
import br.com.usuario.repository.UsuarioRepository;
import br.com.usuario.service.IUsuarioService;


@Service
public class UsuarioService implements IUsuarioService {
    
	@Autowired
	UsuarioRepository repository;

	@Override
	public Usuario salvar(Usuario entity) {
	    return repository.save(entity);
	}

	
		
	@Override
	public Usuario buscarPorId(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return repository.buscarPorEmail(email);
	}

	
	
	
	
		
}
