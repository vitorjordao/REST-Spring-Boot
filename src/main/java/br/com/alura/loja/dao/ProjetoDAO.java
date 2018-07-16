package br.com.alura.loja.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.alura.loja.modelo.Projeto;
import br.com.alura.loja.repository.ProjetoRepository;

@Repository
@Transactional
public class ProjetoDAO {
	@Autowired
	private ProjetoRepository repository;

	public void adiciona(final Projeto projeto) {
		this.repository.save(projeto);
	}

	public Projeto busca(final Long id) {
		return this.repository.findById(id).get();
	}

	public void remove(final long id) {
		this.repository.deleteById(id);
	}

	public void remove(final Projeto projeto) {
		this.repository.delete(projeto);
	}
}
