package br.com.alura.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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

}
