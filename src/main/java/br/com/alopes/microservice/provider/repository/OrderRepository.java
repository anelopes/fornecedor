package br.com.alopes.microservice.provider.repository;

import br.com.alopes.microservice.provider.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
