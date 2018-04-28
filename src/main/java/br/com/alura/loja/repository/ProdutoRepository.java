package br.com.alura.loja.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.loja.modelo.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
