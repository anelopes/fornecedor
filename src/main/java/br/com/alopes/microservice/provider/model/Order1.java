package br.com.alopes.microservice.provider.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order1 { //O "1" é apenas para conseguir criar a tabela no banco. Pois somente "order" é entendido como uma palavra reservada do sql

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer preparationTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order1Id")
    private List<OrderItem> items;

    public Order1() {
    }

    public Order1(List<OrderItem> items) {
        this.items = items;
        this.status = OrderStatus.RECEIVED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
