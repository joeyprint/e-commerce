package th.in.shopdi.FrontendService.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import th.in.shopdi.FrontendService.DTO.Order;
import th.in.shopdi.FrontendService.DTO.OrderMapObject;
import th.in.shopdi.FrontendService.DTO.Product;
import th.in.shopdi.FrontendService.DTO.User;

@Service
public class OrderAdapter {

    @Value("${order.service.url}")
    private String orderServiceURL;

    @Autowired
    private ProductAdapter productAdapter;

    @Autowired
    private UserAdapter userAdapter;

    public OrderMapObject getOrderDetail(long orderId){
        RestTemplate restTemplate = new RestTemplate();
        String url = orderServiceURL+"/order/"+orderId;
        Order order = restTemplate.getForObject(url, Order.class);

        Product product = productAdapter.getProductDetail(order.getProductId());
        User user = userAdapter.getUserDetail(order.getUserId());

        OrderMapObject orderWithObject = new OrderMapObject();
        orderWithObject.setId(orderId);
        orderWithObject.setCreateAt(order.getCreateAt());
        orderWithObject.setProduct(product);
        orderWithObject.setUser(user);
        return orderWithObject;
    }
}