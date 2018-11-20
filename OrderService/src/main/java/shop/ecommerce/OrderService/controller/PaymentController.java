package shop.ecommerce.OrderService.controller;

import co.omise.ClientException;
import co.omise.models.Charge;
import co.omise.models.OmiseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.ecommerce.OrderService.DTO.PaymentToken;
import shop.ecommerce.OrderService.exception.OmiseClientException;
import shop.ecommerce.OrderService.exception.OmiseExpcetion;
import shop.ecommerce.OrderService.exception.ResponseIOException;
import shop.ecommerce.OrderService.model.ChargeResult;
import shop.ecommerce.OrderService.model.Payment;
import shop.ecommerce.OrderService.service.PaymentService;

import java.io.IOException;

@CrossOrigin("*")
@RestController
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @PostMapping("/payment")
  public ResponseEntity<ChargeResult> charge(@RequestBody PaymentToken payment) {
    Charge omiseCharge = null;
    try {
      omiseCharge = paymentService.charge(payment.getToken(), payment.getAmount());
    } catch (IOException e) {
      throw new ResponseIOException(e.getMessage(), e.getCause());
    } catch (OmiseException e) {
      HttpStatus httpStatus = HttpStatus.valueOf(e.getHttpStatusCode());
      throw new OmiseExpcetion(httpStatus, e.getMessage(), e.getCause());
    } catch (ClientException e) {
      throw new OmiseClientException(e.getMessage(), e.getCause());
    }
    ChargeResult chargeResult = new ChargeResult(omiseCharge.getId(), omiseCharge.getAmount(), omiseCharge.getCurrency(), omiseCharge.getStatus().toString());
    return new ResponseEntity<>(chargeResult , HttpStatus.OK);
  }

  @GetMapping("/payment/user/{user_id}")
  public ResponseEntity<Payment> getPaymentByUserId(@PathVariable("user_id") long userId) {
    return new ResponseEntity<Payment>(paymentService.getPaymentByUserId(userId), HttpStatus.OK);
  }
}
