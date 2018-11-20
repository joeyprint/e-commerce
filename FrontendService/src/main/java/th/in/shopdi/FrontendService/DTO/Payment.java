package th.in.shopdi.FrontendService.DTO;

public class Payment {
  private long id;

  private String holderName;

  private String cardNumber;

  private String expiredMonth;

  private String expiredYear;

  private String cvv;

  private long userId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getExpiredMonth() {
    return expiredMonth;
  }

  public void setExpiredMonth(String expiredMonth) {
    this.expiredMonth = expiredMonth;
  }

  public String getExpiredYear() {
    return expiredYear;
  }

  public void setExpiredYear(String expiredYear) {
    this.expiredYear = expiredYear;
  }

  public String getCvv() {
    return cvv;
  }

  public void setCvv(String cvv) {
    this.cvv = cvv;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }
}
