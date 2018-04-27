package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;

public class ClienteTest {

	@Test
	public void testaQueBuscaCarrinhoTrazOCarrinhoEsperado() {
		final Client client = ClientBuilder.newClient();
		final WebTarget target = client.target("http://localhost:8080");
		final String conteudo = target.path("/carrinhos").request().get(String.class);
		final Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}

}
