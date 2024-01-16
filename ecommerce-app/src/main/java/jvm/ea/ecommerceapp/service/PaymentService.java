package jvm.ea.ecommerceapp.service;

import jvm.ea.ecommerceapp.model.Order;
import jvm.ea.ecommerceapp.model.Payment;
import jvm.ea.ecommerceapp.repository.OrderRepository;
import jvm.ea.ecommerceapp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;


    @Autowired
    public PaymentService(PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }
    public Payment createPayment(Long orderId, Payment payment) {
        // Additional business logic if needed

        // Ensure that the associated order exists in the database
        Order order = orderRepository.findById(orderId).orElse(null);

        if (order != null) {
            payment.setOrder(order);

            // Save the payment
            return paymentRepository.save(payment);
        }

        return null; // Order not found
    }
    public Payment updatePayment(Long paymentId, Long orderId, Payment updatedPayment) {
        // Additional business logic if needed

        // Ensure that the associated order exists in the database
        Order order = orderRepository.findById(orderId).orElse(null);

        if (order != null) {
            // Fetch the existing payment from the database
            Payment existingPayment = paymentRepository.findById(paymentId).orElse(null);

            if (existingPayment != null) {
                // Update payment properties
                existingPayment.setAmount(updatedPayment.getAmount());
                // Update other properties as needed

                // Set the associated order
                existingPayment.setOrder(order);

                // Save the updated payment
                return paymentRepository.save(existingPayment);
            }
        }

        return null; // Payment or Order not found
    }
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
