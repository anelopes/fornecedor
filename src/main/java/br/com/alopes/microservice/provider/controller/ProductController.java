package br.com.alopes.microservice.provider.controller;

import br.com.alopes.microservice.provider.model.Product;
import br.com.alopes.microservice.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{state}")
    public List<Product> getByState(@PathVariable("state") String state) {
        return productService.getByState(state);
    }
}
