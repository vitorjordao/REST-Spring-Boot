package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProjetoTest {

	@Test
	public void testaQueAConexaoComOServidorFuncionaNoPathDeProjetos() {
		final Client client = ClientBuilder.newClient();
		final WebTarget target = client.target("http://localhost:8080");
		final String conteudo = target.path("/projetos").request().get(String.class);
		Assert.assertTrue(conteudo.contains("<nome>Minha loja"));

	}

	@Before
	public void inicia() {
		LojaApplication.inicia();
	}

	@After
	public void termina() {
		LojaApplication.termina();
	}

}
