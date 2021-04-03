package br.com.alopes.microservice.provider.repository;

import br.com.alopes.microservice.provider.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
