package jvm.ea.ecommerceapp.model;


import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private Long totalAmount;

    // Other attributes of the cart, e.g., totalAmount, items, etc.

//    @OneToOne(mappedBy = "cart")
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }



    // Constructors, getters, setters, and additional methods

    // Ensure to implement appropriate constructors, getters, setters, and other methods based on your requirements.
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart(){

    }
}
