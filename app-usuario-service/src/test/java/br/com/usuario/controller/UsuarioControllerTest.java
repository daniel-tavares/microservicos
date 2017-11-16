package br.com.usuario.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.usuario.mock.UsuarioMock;
import br.com.usuario.service.impl.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UsuarioService service;
	
	

	@Test
	public void shouldSalvarUsuario() throws Exception {
		given(service.salvar(UsuarioMock.getNovoUsuario())).willReturn(UsuarioMock.getUsuarioSalvo());
		given(service.buscarPorEmail(UsuarioMock.getNovoUsuario().getEmail())).willReturn(null);
		
		mockMvc.perform(post("/v1/usuarios")
				.content(mapper.writeValueAsString(UsuarioMock.getNovoUsuario()))
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(content().json(mapper.writeValueAsString(UsuarioMock.getUsuarioSalvo())));
		        
	}	
	
	

}
