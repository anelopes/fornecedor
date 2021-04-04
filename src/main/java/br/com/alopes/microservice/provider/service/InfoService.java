package br.com.alopes.microservice.provider.service;

import br.com.alopes.microservice.provider.model.ProviderInfo;
import br.com.alopes.microservice.provider.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public ProviderInfo getInfoByState(String state) {
        return infoRepository.findByState(state);
    }
}
