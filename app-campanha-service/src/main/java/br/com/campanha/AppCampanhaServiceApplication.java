package br.com.campanha;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppCampanhaServiceApplication {

	public final static String NOTIFICACAO_QUEUE = "notificacao-queue";

	
	public static void main(String[] args) {
		SpringApplication.run(AppCampanhaServiceApplication.class, args);
	}
}
