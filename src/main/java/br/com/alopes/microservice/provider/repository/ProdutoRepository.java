package br.com.alopes.microservice.provider.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.alopes.microservice.provider.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{

	List<Produto> findByEstado(String estado);
	
	List<Produto> findByIdIn(List<Long> ids);
}
