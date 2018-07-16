package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@Transactional
public class ClienteTest {

	private WebTarget target;
	private Client client;

	@Autowired
	private ProdutoDAO produtoDAO;

	@Test
	public void testaQueBuscaCarrinhoTrazOCarrinhoEsperado() {
		this.client = ClientBuilder.newClient();
		this.target = this.client.target("http://localhost:8080");
		final String conteudo = this.target.path("/carrinhos/1/xml").request().get(String.class);
		final Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}

	@Test
	public void testaQueSuportaNovosCarrinhos() {
		this.client = ClientBuilder.newClient();
		this.target = this.client.target("http://localhost:8080");
		final Produto produto = new Produto(314, "Microfone", 37, 1);
		if (this.produtoDAO == null) {
			System.out.println("Tá null");
		}
		this.produtoDAO.adiciona(produto);

		final Carrinho carrinho = new Carrinho();
		carrinho.adiciona(produto);
		carrinho.setId(15);
		carrinho.setRua("Rua Vergueiro");
		carrinho.setCidade("Sao Paulo");
		final String xml = carrinho.toXML();

		System.out.println(xml);

		final Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

		final Response response = this.target.path("/carrinhos").request().post(entity);
		Assert.assertEquals(201, response.getStatus());
		final String location = response.getHeaderString("Location");
		final String conteudo = this.client.target(location).request().get(String.class);
		Assert.assertTrue(conteudo.contains("Microfone"));
	}

}
