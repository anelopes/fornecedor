package br.com.alopes.microservice.provider.repository;

import br.com.alopes.microservice.provider.model.Order1;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order1, Long> {

}
