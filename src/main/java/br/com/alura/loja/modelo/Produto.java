package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto {

	@ManyToOne
	private Carrinho carrinho;
	private double preco;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private int quantidade;

	public Produto(final long id, final String nome, final double preco, final int quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Produto() {
	}

	public double getPreco() {
		return this.preco;
	}

	public long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public double getPrecoTotal() {
		return this.quantidade * this.preco;
	}

	public void setQuantidade(final int quantidade) {
		this.quantidade = quantidade;
	}

	public Carrinho getCarrinho() {
		return this.carrinho;
	}

	public void setCarrinho(final Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public void setPreco(final double preco) {
		this.preco = preco;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

}
