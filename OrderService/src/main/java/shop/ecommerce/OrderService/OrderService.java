package shop.ecommerce.OrderService;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrder(long id) {
        return orderRepository.findById(id);
    }
}