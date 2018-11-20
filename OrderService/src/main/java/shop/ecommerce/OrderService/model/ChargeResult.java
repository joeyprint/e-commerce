package shop.ecommerce.OrderService.model;

public class ChargeResult {

  private String id;
  private long amount;
  private String currency;
  private String status;

  public ChargeResult(String id, long amount, String currency, String status) {
    this.id = id;
    this.amount = amount;
    this.currency = currency;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
