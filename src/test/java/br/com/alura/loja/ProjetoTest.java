package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.dao.ProdutoDAO;

public class ProjetoTest {

	@Test
	public void testaQueAConexaoComOServidorFuncionaNoPathDeProjetos() {
		final Client client = ClientBuilder.newClient();
		final WebTarget target = client.target("http://localhost:8080");
		final String conteudo = target.path("/projetos/1/xml").request().get(String.class);
		Assert.assertTrue(conteudo.contains("<nome>Minha loja"));

	}

	@Before
	public void inicia() {
		LojaApplication.inicia();
		// this.deletarEntidades();
	}

	@After
	public void termina() {
		LojaApplication.termina();
	}

	private void deletarEntidades() {
		final ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.remove(314);
		final CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
		carrinhoDAO.remove(15);
	}

}
