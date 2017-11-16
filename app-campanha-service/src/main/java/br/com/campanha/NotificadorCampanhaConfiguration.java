package br.com.campanha;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificadorCampanhaConfiguration {
	
	
	private static final String DB_SYNC_NAME="notificacao-exchange";
	
	@Bean
	public TopicExchange databasesyncTopic() {
		return new TopicExchange(DB_SYNC_NAME);
	}

}