package br.com.campanha.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.campanha.mock.CampanhaUsuarioMock;
import br.com.campanha.service.impl.CampanhaUsuarioService;
import br.com.campanha.vo.CampanhaUsuarioVO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CampanhaUsuarioControllerTest {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CampanhaUsuarioService service;

	
	@Test
	public void shouldAssociarUsuarioACamapanha() throws Exception {
		

		String json=mapper.writeValueAsString(CampanhaUsuarioMock.getCampanhaUsuario());
		
		mockMvc.perform(post("/v1/campanhaUsuario/associacao")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
				
		        
	}	
	
}
