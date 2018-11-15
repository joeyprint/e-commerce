package main.java.shop.ecommerce.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/{orders_id}")
    public ResponseEntity<Order> getOrder(@PathVariable("order_id") long orderId) {
        Order getOrder = orderService.getOrder(orderId);
        return new ResponseEntity<Order>(getOrder, HttpStatus.OK);
    }

}