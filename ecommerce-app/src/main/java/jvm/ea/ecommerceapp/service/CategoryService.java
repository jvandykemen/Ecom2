package jvm.ea.ecommerceapp.service;

import jvm.ea.ecommerceapp.model.Category;
import jvm.ea.ecommerceapp.model.Product;
import jvm.ea.ecommerceapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public Category createCategory(Category category) {
        // Additional business logic if needed
        return categoryRepository.save(category);
    }
    public Category updateCategory(Long categoryId, Category updatedCategory,List<Product> updatedProducts) {
        // Additional business logic if needed
        Category existingCategory = categoryRepository.findById(categoryId).orElse(null);
        if (existingCategory != null) {
            // Update category properties
            existingCategory.getProducts().clear();
            existingCategory.getProducts().addAll(updatedProducts);
            existingCategory.setCategoryName(updatedCategory.getCategoryName());
            // Update other properties as needed
            return categoryRepository.save(existingCategory);
        }
        return null; // Category not found
    }
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
