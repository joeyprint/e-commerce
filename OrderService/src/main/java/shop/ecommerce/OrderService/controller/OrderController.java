package shop.ecommerce.OrderService.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import shop.ecommerce.OrderService.model.Order;
import shop.ecommerce.OrderService.service.OrderService;

@CrossOrigin("*")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{order_id}")
    public ResponseEntity<Order> getOrder(@PathVariable("order_id") long orderId) {
        Order getOrder = orderService.getOrder(orderId);
        return new ResponseEntity<Order>(getOrder, HttpStatus.OK);
    }

    @PostMapping("/user/{user_id}/product/{product_id}/order/create") 
    public ResponseEntity<Order> createOrder(@PathVariable("user_id") long userId, @PathVariable("product_id") long productId, @Valid @RequestBody Order order){
        Order createOrder = orderService.createOrder(userId, productId, order);
        return new  ResponseEntity<Order>(createOrder, HttpStatus.OK);
    }
    


}