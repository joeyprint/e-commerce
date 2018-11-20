package th.in.shopdi.FrontendService.DTO;

public class User {
  private long id;

  private String facebookId;

  private String firstname;

  private String lastname;

  private String email;

  private String address;

  private String telNo;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTelNo() {
    return telNo;
  }

  public void setTelNo(String telNo) {
    this.telNo = telNo;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getFacebookId() {
    return facebookId;
  }

  public void setFacebookId(String facebookId) {
    this.facebookId = facebookId;
  }

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
}
