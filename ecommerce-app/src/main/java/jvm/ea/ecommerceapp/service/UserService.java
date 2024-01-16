package jvm.ea.ecommerceapp.service;

import jvm.ea.ecommerceapp.model.Address;
import jvm.ea.ecommerceapp.model.Cart;
import jvm.ea.ecommerceapp.model.User;
import jvm.ea.ecommerceapp.repository.AddressRepository;
import jvm.ea.ecommerceapp.repository.CartRepository;
import jvm.ea.ecommerceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    public User createUser(Long addressId, User newUser) {
        // Additional business logic if needed

        // Ensure that the associated address exists in the database
        Address address = addressRepository.findById(addressId).orElse(null);

        if (address != null) {
            newUser.setAddress(address);

            // Create a new cart for the user (assuming one-to-one relationship)
            Cart cart = new Cart();
            newUser.setUserId(cart.getCartId());

            // Save the new user
            return userRepository.save(newUser);
        }

        return null; // Address not found
    }
    public User updateUser(Long userId, User updatedUser) {
        // Additional business logic if needed
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            // Update user properties
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            // Update other properties as needed
            return userRepository.save(existingUser);
        }
        return null; // User not found
    }
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

