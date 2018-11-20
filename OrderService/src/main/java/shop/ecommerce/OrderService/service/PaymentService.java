package shop.ecommerce.OrderService.service;

import co.omise.Client;
import co.omise.ClientException;
import co.omise.models.Charge;
import co.omise.models.OmiseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import shop.ecommerce.OrderService.model.Payment;
import shop.ecommerce.OrderService.repository.PaymentRepositoryInterface;

import java.io.IOException;

@Service
public class PaymentService {

  @Autowired
  private PaymentRepositoryInterface paymentRepositoryInterface;

  private Client omiseClient;

  @Value("${omise.public-key}")
  private String PUBLIC_KEY;

  @Value("${omise.secret-key}")
  private String SECRET_KEY;

  private static long ONE_HUNDRED_SATANG = 100;
  private static String TH_BAHT = "THB";

  public Charge charge(String token, long price) throws IOException, OmiseException, ClientException {
    omiseClient = new Client(PUBLIC_KEY, SECRET_KEY);
    Charge.Create chargeSpec = new Charge.Create();
    chargeSpec
            .amount(price * ONE_HUNDRED_SATANG)
            .currency(TH_BAHT)
            .card(token);
    Charge charge = this.omiseClient.charges().create(chargeSpec);
    return charge;
  }

  public Payment getPaymentByUserId(long userId) {
    return paymentRepositoryInterface.findByUserId(userId);
  }
}
