package br.com.alura.loja.dao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.loja.modelo.Projeto;
import br.com.alura.loja.repository.ProjetoRepository;

public class ProjetoDAO {
	@Autowired
	private ProjetoRepository repository;

	public void adiciona(final Projeto projeto) {
		this.repository.save(projeto);
	}

	public Projeto busca(final long id) {
		return this.repository.findById(id).get();
	}

	public void remove(final long id) {
		this.repository.deleteById(id);
	}

	public void remove(final Projeto projeto) {
		this.repository.delete(projeto);
	}
}
