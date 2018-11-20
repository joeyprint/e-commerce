package shop.ecommerce.OrderService.controller;

import co.omise.Client;
import co.omise.ClientException;
import co.omise.models.Charge;
import co.omise.models.OmiseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shop.ecommerce.OrderService.exception.OmiseClientException;
import shop.ecommerce.OrderService.exception.OmiseExpcetion;
import shop.ecommerce.OrderService.exception.ResponseIOException;
import shop.ecommerce.OrderService.model.ChargeResult;
import shop.ecommerce.OrderService.model.Payment;
import shop.ecommerce.OrderService.service.OmiseService;

import java.io.IOException;

@CrossOrigin("*")
@RestController
public class OmiseController {

  @Autowired
  private OmiseService omiseService;

  @PostMapping("/payment")
  public ResponseEntity<ChargeResult> create(@RequestBody Payment payment) {
    Charge omiseCharge = null;
    try {
      omiseCharge = omiseService.charge(payment.getToken(), payment.getAmount());
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
}
