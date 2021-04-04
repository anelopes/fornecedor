package br.com.alopes.microservice.provider.repository;

import br.com.alopes.microservice.provider.model.ProviderInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends CrudRepository<ProviderInfo, Long> {

    ProviderInfo findByState(String state);
}
