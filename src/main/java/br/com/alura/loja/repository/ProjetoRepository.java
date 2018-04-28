package br.com.alura.loja.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.loja.modelo.Projeto;

public interface ProjetoRepository extends CrudRepository<Projeto, Long> {
}
