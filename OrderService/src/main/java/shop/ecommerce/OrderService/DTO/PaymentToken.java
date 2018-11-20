package shop.ecommerce.OrderService.DTO;

public class PaymentToken {

  private String token;

  private long amount;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }
}
