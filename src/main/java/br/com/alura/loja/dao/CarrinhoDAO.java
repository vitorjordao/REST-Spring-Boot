package br.com.alura.loja.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.repository.CarrinhoRepository;

@Repository
@Transactional
public class CarrinhoDAO {
	@Autowired
	private CarrinhoRepository repository;

	public void adiciona(final Carrinho carrinho) {
		this.repository.save(carrinho);
	}

	public Carrinho busca(final long id) {
		return this.repository.findById(id).get();
	}

	public void remove(final long id) {
		this.repository.deleteById(id);
	}

	public void remove(final Carrinho carrinho) {
		this.repository.delete(carrinho);
	}

}
