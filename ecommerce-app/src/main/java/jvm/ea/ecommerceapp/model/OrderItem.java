package jvm.ea.ecommerceapp.model;


import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "orderId2")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(nullable = false, columnDefinition = "INTEGER") // Specify the correct JDBC type

    private int quantity;

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public  OrderItem(){


    // Constructors, getters, setters, and additional methods

    // Ensure to implement appropriate constructors, getters, setters, and other methods based on your requirements.
}

}
