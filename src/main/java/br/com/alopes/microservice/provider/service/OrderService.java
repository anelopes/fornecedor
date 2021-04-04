package br.com.alopes.microservice.provider.service;

import br.com.alopes.microservice.provider.dto.OrderItemDTO;
import br.com.alopes.microservice.provider.model.Order1;
import br.com.alopes.microservice.provider.model.OrderItem;
import br.com.alopes.microservice.provider.model.Product;
import br.com.alopes.microservice.provider.repository.OrderRepository;
import br.com.alopes.microservice.provider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order1 doOrder(List<OrderItemDTO> items) {

        if (items == null) {
            return null;
        }

        List<OrderItem> list = toOrderItem(items);
        Order1 order1 = new Order1(list);
        order1.setPreparationTime(items.size());
        return orderRepository.save(order1);
    }

    public Order1 getById(Long id) {
        return this.orderRepository.findById(id).orElse(new Order1());
    }

    private List<OrderItem> toOrderItem(List<OrderItemDTO> items) {

        List<Long> productsIds = items
                .stream()
                .map(item -> item.getId())
                .collect(Collectors.toList());

        List<Product> OrderProducts = productRepository.findByIdIn(productsIds);

        List<OrderItem> OrderItems = items
                .stream()
                .map(item -> {
                    Product product = OrderProducts
                            .stream()
                            .filter(p -> p.getId() == item.getId())
                            .findFirst().get();

                    OrderItem orderItem = new OrderItem();
                    orderItem.setProduct(product);
                    orderItem.setQuantity(item.getQuantity());
                    return orderItem;
                })
                .collect(Collectors.toList());
        return OrderItems;
    }
}
