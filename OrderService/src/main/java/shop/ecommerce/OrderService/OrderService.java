package shop.ecommerce.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.ecommerce.ProductAdapter.ProductAdapter;
import shop.ecommerce.UserAdapter.UserAdapter;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserAdapter userAdapter;

    @Autowired
    private ProductAdapter productAdapter;

    public Order getOrder(long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(long userId, long productId, Order order) {
        order.setUser(userAdapter.getUserDetail(userId));
        order.setProduct(productAdapter.getProductDetail(productId));
        return orderRepository.save(order);
    }

}