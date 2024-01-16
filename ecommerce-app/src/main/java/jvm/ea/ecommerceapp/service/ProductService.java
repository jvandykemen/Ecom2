package jvm.ea.ecommerceapp.service;

import jvm.ea.ecommerceapp.model.Category;
import jvm.ea.ecommerceapp.model.Product;
import jvm.ea.ecommerceapp.repository.CategoryRepository;
import jvm.ea.ecommerceapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
    public Product createProduct(Product product, Long categoryId) {
        // Additional business logic if needed
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            product.setCategory(category);
            return productRepository.save(product);
        }
        return null; // Category not found
    }
    public Product updateProduct(Long productId, Product updatedProduct) {
        // Additional business logic if needed
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            // Update product properties
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setStockQuantity(updatedProduct.getStockQuantity());
            existingProduct.setCategory(updatedProduct.getCategory());
            // Update other properties as needed
            return productRepository.save(existingProduct);
        }
        return null; // Product not found
    }
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
