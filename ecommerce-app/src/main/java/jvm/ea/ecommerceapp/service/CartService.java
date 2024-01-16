package jvm.ea.ecommerceapp.service;

import jvm.ea.ecommerceapp.model.Cart;
import jvm.ea.ecommerceapp.model.User;
import jvm.ea.ecommerceapp.repository.CartRepository;
import jvm.ea.ecommerceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public Cart createCart(Cart cart) {
        // Additional business logic if needed
        return cartRepository.save(cart);
    }

    public Cart updateCart(Long cartId, Cart updatedCart,User updatedUser) {
        // Additional business logic if needed
        Cart existingCart = cartRepository.findById(cartId).orElse(null);

        if (existingCart != null) {
            // Update cart properties
            existingCart.setTotalAmount(updatedCart.getTotalAmount());
            // Update other properties as needed

            existingCart.setUser(updatedUser);

            // Save the updated cart
            return cartRepository.save(existingCart);
        }

        return null; // Cart not found
    }
    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}