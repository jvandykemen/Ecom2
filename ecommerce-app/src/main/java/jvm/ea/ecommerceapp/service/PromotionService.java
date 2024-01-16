package jvm.ea.ecommerceapp.service;

import jvm.ea.ecommerceapp.model.Promotion;
import jvm.ea.ecommerceapp.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class PromotionService {

    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion getPromotionById(Long promotionId) {
        return promotionRepository.findById(promotionId).orElse(null);
    }
    public Promotion createPromotion(Promotion promotion) {
        // Additional business logic if needed
        return promotionRepository.save(promotion);
    }
    public Promotion updatePromotion(Long promotionId, Promotion updatedPromotion) {
        // Additional business logic if needed
        Promotion existingPromotion = promotionRepository.findById(promotionId).orElse(null);
        if (existingPromotion != null) {
            // Update promotion properties
            existingPromotion.setPromoCode(updatedPromotion.getPromoCode());
            existingPromotion.setDiscountAmount(updatedPromotion.getDiscountAmount());
            existingPromotion.setStartDate(updatedPromotion.getStartDate());
            existingPromotion.setEndDate(updatedPromotion.getEndDate());
            // Update other properties as needed
            return promotionRepository.save(existingPromotion);
        }
        return null; // Promotion not found
    }
    public void deletePromotion(Long promotionId) {
        promotionRepository.deleteById(promotionId);
    }
}
