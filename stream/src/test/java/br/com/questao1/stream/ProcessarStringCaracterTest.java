package br.com.questao1.stream;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessarStringCaracterTest {

	@Test
	public void shouldProcessamentoCaracter() throws Exception {
		Stream stream=new StreamImpl("aAbBABacafe");
		char retorno =ProcessarStringCaracter.processar(stream);
		
		assertEquals(retorno, 'e');
	}	
	
	

}
