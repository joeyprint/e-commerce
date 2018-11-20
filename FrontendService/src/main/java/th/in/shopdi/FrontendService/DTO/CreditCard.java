package th.in.shopdi.FrontendService.DTO;

public class CreditCard {
  private String cardnumber;
  private String fullname;
  private String expiredMonth;
  private String expiredYear;

  public String getCardnumber() {
    String result = "";
    for (int letterPosition = 0; letterPosition < this.cardnumber.length(); letterPosition++) {
      if (letterPosition % 4 == 0) {
        result += " ";
      }
      result += cardnumber.charAt(letterPosition);
    }
    return result;
  }

  public void setCardnumber(String cardnumber) {
    this.cardnumber = cardnumber;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
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
