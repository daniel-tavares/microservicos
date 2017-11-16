package br.com.campanha.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

import br.com.campanha.mock.CampanhaMock;
import br.com.campanha.service.impl.CampanhaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CampanhaControllerTest {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CampanhaService service;

	

	@Test
	public void shouldSalvarCampanha() throws Exception {
		given(service.salvar(CampanhaMock.getCampanha())).willReturn(CampanhaMock.getCampanhaSalva());
		
		
		mockMvc.perform(post("/v1/campanhas")
				.content(mapper.writeValueAsString(CampanhaMock.getCampanha()))
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(content().json("{\"id\":1,\"nome\":\"Campanha 1\",\"idTime\":1,\"dataInicioVigencia\":\"01/01/2016\",\"dataFimVigencia\":\"01/12/2017\"}"));
		        
	}	
	
	
	@Test
	public void shouldAtualizarCampanha() throws Exception {
		given(service.salvar(CampanhaMock.getCampanhaAtualizada())).willReturn(CampanhaMock.getCampanhaAtualizada());
		given(service.buscarPorId(CampanhaMock.getCampanhaAtualizada().getId())).willReturn(CampanhaMock.getCampanhaSalva());
		
		
		String json =mapper.writeValueAsString(CampanhaMock.getCampanhaAtualizada());
		
		mockMvc.perform(put("/v1/campanhas")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(json));
		        
	}
		
	
	@Test
	public void shouldExcluirCampanha() throws Exception {
		given(service.buscarPorId(CampanhaMock.getCampanhaSalva().getId())).willReturn(CampanhaMock.getCampanhaSalva());
			
		String json =mapper.writeValueAsString(CampanhaMock.getCampanhaSalva());
		
		mockMvc.perform(delete("/v1/campanhas/"+CampanhaMock.getCampanhaSalva().getId())
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(json));
		 
	}
	
	
	@Test
	public void shouldBucarCampanhaParaTimeSemAssociarComUsuario() throws Exception {
		Long idUsuario=1l;
    	Long idTime=2l;
		
		given(service.buscarSemAssociacaoUsuario(idUsuario, idTime)).willReturn(CampanhaMock.getListaCampanhaNaoAssociadaAoUsuario());
		  
		mockMvc.perform(get("/v1/campanhas/semAssociacaoUsuario/"+idUsuario+"/time/"+idTime)
				.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("[0].idTime", is(2)))
				.andExpect(content().json(mapper.writeValueAsString(CampanhaMock.getListaCampanhaNaoAssociadaAoUsuario())));
		        
	}

}
