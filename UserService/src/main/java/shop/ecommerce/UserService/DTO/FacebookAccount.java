package shop.ecommerce.UserService.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FacebookAccount {
  @JsonProperty("first_name")
  private String firstname;

  @JsonProperty("last_name")
  private String lastname;

  @JsonProperty("email")
  private String email;

  @JsonProperty("id")
  private String facebookId;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFacebookId() {
    return facebookId;
  }

  public void setFacebookId(String facebookId) {
    this.facebookId = facebookId;
  }
}
