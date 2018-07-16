package br.com.alura.loja.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.thoughtworks.xstream.XStream;

@Entity
public class Carrinho {

	@OneToMany
	private final List<Produto> produtos = new ArrayList<>();
	private String rua;
	private String cidade;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Carrinho(final String rua, final String cidade, final long id) {
		this.rua = rua;
		this.cidade = cidade;
		this.id = id;
	}

	public Carrinho() {
	}

	public Carrinho adiciona(final Produto produto) {
		this.produtos.add(produto);
		return this;
	}

	public Carrinho setId(final long id) {
		this.id = id;
		return this;
	}

	public Carrinho para(final String rua, final String cidade) {
		this.rua = rua;
		this.cidade = cidade;
		return this;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(final String rua) {
		this.rua = rua;
	}

	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}

	public long getId() {
		return this.id;
	}

	public void remove(final long id) {
		for (final Iterator<Produto> iterator = this.produtos.iterator(); iterator.hasNext();) {
			final Produto produto = iterator.next();
			if (produto.getId() == id) {
				iterator.remove();
			}
		}
	}

	public void troca(final Produto produto) {
		this.remove(produto.getId());
		this.adiciona(produto);
	}

	public void trocaQuantidade(final Produto produto) {
		for (final Object element : this.produtos) {
			final Produto p = (Produto) element;
			if (p.getId() == produto.getId()) {
				p.setQuantidade(produto.getQuantidade());
				return;
			}
		}
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public String toXML() {
		return new XStream().toXML(this);
	}

	public String getCidade() {
		return this.cidade;
	}

}
