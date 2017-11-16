package br.com.campanha;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppCampanhaServiceApplication {

	public final static String NOTIFICACAO_QUEUE = "notificacao-queue";

	
	public static void main(String[] args) {
		SpringApplication.run(AppCampanhaServiceApplication.class, args);
	}
	
	
//	@Bean
//	Queue queue() {
//		return new Queue(NOTIFICACAO_QUEUE, false);
//	}
//
//	@Bean
//	TopicExchange exchange() {
//		return new TopicExchange("notificacao-exchange");
//	}
//
//	@Bean
//	Binding binding(Queue queue, TopicExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with(NOTIFICACAO_QUEUE);
//	}
//
//	@Bean
//	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//			MessageListenerAdapter listenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(NOTIFICACAO_QUEUE);
//		container.setMessageListener(listenerAdapter);
//		return container;
//	}
//
//	@Bean
//	MessageListenerAdapter listenerAdapter(CampanhaMessageListener receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessage");
//	}



}
