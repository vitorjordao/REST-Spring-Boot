package br.com.alura.loja.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.loja.modelo.Carrinho;

public interface CarrinhoRepository extends CrudRepository<Carrinho, Long> {
}
