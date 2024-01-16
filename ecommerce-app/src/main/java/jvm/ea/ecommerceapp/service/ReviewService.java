package jvm.ea.ecommerceapp.service;

import jvm.ea.ecommerceapp.model.Product;
import jvm.ea.ecommerceapp.model.Review;
import jvm.ea.ecommerceapp.model.User;
import jvm.ea.ecommerceapp.repository.ProductRepository;
import jvm.ea.ecommerceapp.repository.ReviewRepository;
import jvm.ea.ecommerceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }
    public Review createReview(Long productId, Long userId, Review newReview) {
        // Additional business logic if needed

        // Ensure that the associated product and user exist in the database
        Product product = productRepository.findById(productId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (product != null && user != null) {
            newReview.setProduct(product);
            newReview.setUser(user);

            // Save the new review
            return reviewRepository.save(newReview);
        }

        return null; // Product or User not found
    }
    public Review updateReview(Long reviewId, Review updatedReview) {
        // Additional business logic if needed

        // Fetch the existing review from the database
        Review existingReview = reviewRepository.findById(reviewId).orElse(null);

        if (existingReview != null) {
            // Update review properties
            existingReview.setRating(updatedReview.getRating());
            existingReview.setComment(updatedReview.getComment());
            // Update other properties as needed

            // Ensure that the associated product and user exist in the database
            Product product = productRepository.findById(updatedReview.getProduct().getProductId()).orElse(null);
            User user = userRepository.findById(updatedReview.getUser().getUserId()).orElse(null);

            if (product != null && user != null) {
                // Set the associated product and user
                existingReview.setProduct(product);
                existingReview.setUser(user);

                // Save the updated review
                return reviewRepository.save(existingReview);
            }
        }

        return null; // Review, Product, or User not found
    }
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
