package br.com.alopes.microservice.fornecedor.repository;

import br.com.alopes.microservice.fornecedor.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
