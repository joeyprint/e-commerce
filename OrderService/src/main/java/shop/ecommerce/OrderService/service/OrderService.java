package shop.ecommerce.OrderService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.ecommerce.OrderService.model.Order;
import shop.ecommerce.OrderService.repository.OrderRepository;
import shop.ecommerce.ProductAdapter.ProductAdapter;
import shop.ecommerce.UserAdapter.UserAdapter;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrder(long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(long userId, long productId, Order order) {
        order.setUserId(userId);
        order.setProductId(productId);
        return orderRepository.save(order);
    }

}