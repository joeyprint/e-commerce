package shop.ecommerce.OrderService.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String holderName;

  @Column(length = 16)
  private String cardNumber;

  @Column(length = 2)
  private String expiredMonth;

  @Column(length = 2)
  private String expiredYear;

  @Column(length = 3)
  private String cvv;

  private long userId;

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
}
