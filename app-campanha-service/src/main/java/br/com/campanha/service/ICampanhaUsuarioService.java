package br.com.campanha.service;

import br.com.campanha.vo.CampanhaUsuarioVO;


public interface ICampanhaUsuarioService{
	
	CampanhaUsuarioVO associar(CampanhaUsuarioVO campanhaCliente);
	
	boolean isCampanhaUsuario(Long idUsuario);
}