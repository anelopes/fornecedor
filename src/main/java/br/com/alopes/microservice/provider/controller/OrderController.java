package br.com.alopes.microservice.provider.controller;

import br.com.alopes.microservice.provider.dto.OrderItemDTO;
import br.com.alopes.microservice.provider.model.Order;
import br.com.alopes.microservice.provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order doOrder(@RequestBody List<OrderItemDTO> products) {
        return orderService.doOrder(products);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.getById(id);
    }
}
