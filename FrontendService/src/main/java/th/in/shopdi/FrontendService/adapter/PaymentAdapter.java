package th.in.shopdi.FrontendService.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.in.shopdi.FrontendService.DTO.Payment;

@Service
public class PaymentAdapter {

  @Value("${payment.service.url}")
  private String paymentServiceURL;

  public Payment getPaymentByUserId(long userId){
    RestTemplate restTemplate = new RestTemplate();
    String url = paymentServiceURL + "/payment/user/" + userId;
    Payment payment = restTemplate.getForObject(url, Payment.class);
    return payment;
  }
}
