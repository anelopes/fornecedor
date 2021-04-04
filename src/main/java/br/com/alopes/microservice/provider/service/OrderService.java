package br.com.alopes.microservice.provider.service;

import br.com.alopes.microservice.provider.dto.OrderItemDTO;
import br.com.alopes.microservice.provider.model.Order;
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

    public Order doOrder(List<OrderItemDTO> items) {

        if (items == null) {
            return null;
        }

        List<OrderItem> list = toOrderItem(items);
        Order order = new Order(list);
        order.setPreparationTime(items.size());
        return orderRepository.save(order);
    }

    public Order getById(Long id) {
        return this.orderRepository.findById(id).orElse(new Order());
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
