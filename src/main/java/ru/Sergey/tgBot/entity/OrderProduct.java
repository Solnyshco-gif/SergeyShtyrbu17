package ru.Sergey.tgBot.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "order_products")
public class OrderProduct {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ClientOrder clientOrder;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Integer countProduct;

    public OrderProduct() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(Integer countProduct) {
        this.countProduct = countProduct;
    }
}
