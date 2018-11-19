package shop.ecommerce.UserService.DTO;

public class AuthResponse {
  private String firstname;
  private String lastname;
  private String token;
  private long expiryDate;

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public long getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(long expiryDate) {
    this.expiryDate = expiryDate;
  }
}
