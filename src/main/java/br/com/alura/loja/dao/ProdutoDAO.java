package br.com.alura.loja.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.repository.ProdutoRepository;

@Repository
@Transactional
public class ProdutoDAO {
	@Autowired
	private ProdutoRepository repository;

	public void adiciona(final Produto produto) {
		this.repository.save(produto);
	}

	public Produto busca(final long id) {
		return this.repository.findById(id).get();
	}

	public void remove(final long id) {
		this.repository.deleteById(id);
	}

	public void remove(final Produto produto) {
		this.repository.delete(produto);
	}

}
