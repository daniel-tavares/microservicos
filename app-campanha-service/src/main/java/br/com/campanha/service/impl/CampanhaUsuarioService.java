package br.com.campanha.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campanha.model.Campanha;
import br.com.campanha.model.CampanhaUsuario;
import br.com.campanha.repository.CampanhaRepository;
import br.com.campanha.repository.CampanhaUsuarioRepository;
import br.com.campanha.service.ICampanhaUsuarioService;
import br.com.campanha.validation.ValidationAPI;
import br.com.campanha.vo.CampanhaUsuarioVO;

@Service
public class CampanhaUsuarioService implements ICampanhaUsuarioService {

	@Autowired
    CampanhaUsuarioRepository repository;
	
	@Autowired
    CampanhaRepository campanhaRepository;
	
	@Override
	public CampanhaUsuarioVO associar(CampanhaUsuarioVO campanhaUsuarioVO) {
		
		
		
		for (Long idCampanha : campanhaUsuarioVO.getCampanhas()) {
			 Campanha campanha =campanhaRepository.findOne(idCampanha); 
             ValidationAPI.validaCampanhaExiste(campanha, idCampanha);
			 
			 CampanhaUsuario  campanhaUsuario=new CampanhaUsuario();
		     campanhaUsuario.setCampanha(campanha);  
		     campanhaUsuario.setIdUsuario(campanhaUsuarioVO.getUsuario());
		     repository.save(campanhaUsuario);
		}
		return campanhaUsuarioVO;
	}

	@Override
	public boolean isCampanhaUsuario(Long idUsuario) {
		Optional<Long> qtdeRegistro=Optional.ofNullable(repository.isCampanhaUsuario(idUsuario));
		if(qtdeRegistro.get()>0) 
			return true;
		
		return false;
	}
	
	

}
