package br.com.campanha.mock;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import br.com.campanha.vo.CampanhaUsuarioVO;

@Component
public class CampanhaUsuarioMock {
    

	public static CampanhaUsuarioVO getCampanhaUsuario() {
		CampanhaUsuarioVO campanhaUsuarioVO=new CampanhaUsuarioVO();
		campanhaUsuarioVO.setUsuario(1l);
		campanhaUsuarioVO.setCampanhas(Arrays.asList(2l,3l,4l));
		
		return campanhaUsuarioVO;
	}
}
