package shop.ecommerce.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.ecommerce.OrderService.model.Payment;

@Repository
public interface PaymentRepositoryInterface extends JpaRepository<Payment, Long> {
  Payment findByUserId(long userID);
}
