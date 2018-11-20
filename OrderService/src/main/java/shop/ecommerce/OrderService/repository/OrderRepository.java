package shop.ecommerce.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.ecommerce.OrderService.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findById(long id);
}
