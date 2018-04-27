package br.com.alura.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.alura.loja.modelo.Projeto;

public class ProjetoDAO {
	@PersistenceContext
	private EntityManager manager;

	public void adiciona(final Projeto projeto) {
		this.manager.persist(projeto);
	}

	public Projeto busca(final Long id) {
		return this.manager.createQuery("select distinct(p) from Projeto p where p.id = :id", Projeto.class)
				.setParameter("id", id).getSingleResult();
	}

	public void remove(final long id) {
		final Projeto projeto = this.manager
				.createQuery("select distinct(p) from Projeto p where p.id = :id", Projeto.class).setParameter("id", id)
				.getSingleResult();
		this.manager.remove(projeto);
	}

	public void remove(final Projeto projeto) {
		this.manager.remove(projeto);
	}
}
