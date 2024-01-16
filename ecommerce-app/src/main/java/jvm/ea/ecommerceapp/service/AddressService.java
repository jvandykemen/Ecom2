package jvm.ea.ecommerceapp.service;

import jvm.ea.ecommerceapp.model.Address;
import jvm.ea.ecommerceapp.model.User;
import jvm.ea.ecommerceapp.repository.AddressRepository;
import jvm.ea.ecommerceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    public Address createAddress(Address address) {
        // Additional business logic if needed
        return addressRepository.save(address);
    }


    public Address updateAddress(Long addressId, Address updatedAddress,List<User> updatedUsers) {
        // Additional business logic if needed
        Address existingAddress = addressRepository.findById(addressId).orElse(null);
        if (existingAddress != null) {
            // Update address properties
            existingAddress.setStreet(updatedAddress.getStreet());
            existingAddress.setCity(updatedAddress.getCity());
            existingAddress.setState(updatedAddress.getState());
            existingAddress.setPostalCode(updatedAddress.getPostalCode());
            existingAddress.setCountry(updatedAddress.getCountry());
            for (User updatedUser : updatedUsers) {
                User existingUser = userRepository.findById(updatedUser.getUserId()).orElse(null);
                if (existingUser != null) {
                    existingAddress.getUsers().add(existingUser);
                }
            }
            // Update other properties as needed
            return addressRepository.save(existingAddress);
        }
        return null; // Address not found
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}