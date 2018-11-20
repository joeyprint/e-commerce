package th.in.shopdi.FrontendService.DTO;

public class Payment {
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
