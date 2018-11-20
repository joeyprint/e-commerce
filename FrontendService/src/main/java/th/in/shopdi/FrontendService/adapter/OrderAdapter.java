package th.in.shopdi.FrontendService.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import th.in.shopdi.FrontendService.DTO.Order;

@Service
public class OrderAdapter {

    @Value("${order.service.url}")
    private String orderServiceURL;

    public Order getOrderDetail(long orderId){
        RestTemplate restTemplate = new RestTemplate();
        String url = orderServiceURL+"/order/"+orderId;
        Order order = restTemplate.getForObject(url, Order.class);
        return order;
    }
}