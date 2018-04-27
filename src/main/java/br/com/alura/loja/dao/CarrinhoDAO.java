package br.com.alura.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.alura.loja.modelo.Carrinho;

@Repository
@Transactional
public class CarrinhoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void adiciona(final Carrinho carrinho) {
		this.manager.persist(carrinho);
	}

	public Carrinho busca(final int id) {
		if (this.manager == null) {
			System.out.println("Tá nulo");
		}
		return this.manager.createQuery("select p from Carrinho p where p.id = :id", Carrinho.class)
				.setParameter("id", id).getSingleResult();
	}

	public void remove(final long id) {
		final Carrinho carrinho = this.manager
				.createQuery("select distinct(p) from Carrinho p where p.id = :id", Carrinho.class)
				.setParameter("id", id).getSingleResult();
		this.manager.remove(carrinho);
	}

	public void remove(final Carrinho carrinho) {
		this.manager.remove(carrinho);
	}

}
