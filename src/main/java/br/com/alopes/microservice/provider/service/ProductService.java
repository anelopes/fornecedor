package br.com.alopes.microservice.provider.service;

import br.com.alopes.microservice.provider.model.Product;
import br.com.alopes.microservice.provider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getByState(String state) {
        return productRepository.findByState(state);
    }
}
