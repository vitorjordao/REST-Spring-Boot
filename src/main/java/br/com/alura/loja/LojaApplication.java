package br.com.alura.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LojaApplication {

	private static ConfigurableApplicationContext run;

	public static void main(final String[] args) {
		inicia();
	}

	static void inicia() {
		run = SpringApplication.run(LojaApplication.class, "");
	}

	static void termina() {
		run.stop();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
