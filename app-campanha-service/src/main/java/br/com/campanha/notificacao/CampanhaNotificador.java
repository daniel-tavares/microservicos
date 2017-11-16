package br.com.campanha.notificacao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.campanha.model.Campanha;


@Service
public class CampanhaNotificador {
	
	private static Logger log = Logger.getLogger(CampanhaNotificador.class);
	
	private static final String ROUTINGKEY_CADASTRO="operacao.cadastro";
	
	private static final String ROUTINGKEY_ATUALIZACAO="operacao.atualizacao";
	
	
	@Autowired
	private RabbitTemplate template;
	
	@Autowired
	private TopicExchange databasesyncTopic;
	
	
	
	public void notificarCadastro(Campanha campanha) throws AmqpException, JsonProcessingException {
		notificar(campanha, ROUTINGKEY_CADASTRO);
	}

	
	public void notificarAlteracoes(List<Campanha> campanhasAlteradas) throws AmqpException, JsonProcessingException {
		for (Campanha campanha : campanhasAlteradas) {
			notificar(campanha, ROUTINGKEY_ATUALIZACAO);
		}
	}

	private String toJSON(Campanha campanha) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(campanha);
		log.debug("from " + campanha + " toJson " + json);
		return json;
	}
	
	private void notificar(Campanha campanha, String routingKey) throws AmqpException, JsonProcessingException {
		template.convertAndSend(databasesyncTopic.getName(), routingKey, toJSON(campanha));
	}

}