package jvm.ea.ecommerceapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")

public class Product {

    /*
    productId is the primary key field for the Product entity.
@GeneratedValue(strategy = GenerationType.IDENTITY) indicates
that the productId values will be automatically generated
 by the database using an identity (auto-increment) strategy.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    @Column(columnDefinition = "TEXT") // For longer text
    /*@Column(columnDefinition = "TEXT")
Annotation specifying the column definition for the description field.
 In this case, it's set
 to "TEXT," indicating that the description
should be stored as a large text field in the database.
     */

    private String description;

    private BigDecimal price;

    private int stockQuantity;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    /*@JoinColumn(name = "category_id") Annotation:
Specifies the name of the foreign key column in the Product table that references the primary key
 column in the associated Category table.
In this case, it suggests that there is a column named category_id in the Product
 table that serves as a foreign key, linking each Product to a specific Category.
     */

    private Category category;

    public Product(List<OrderItem> orderItems){
        this.orderItems = orderItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Constructors, getters, setters, and additional methods

    // Consider adding @OneToMany relationship with OrderItem if needed
}
