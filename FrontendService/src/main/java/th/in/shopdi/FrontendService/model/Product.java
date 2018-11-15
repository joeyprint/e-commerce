package th.in.shopdi.FrontendService.model;

public class Product {
  private Long id;
  private String productname;
  private double price;
  private String imageURL;
  private String description;

  public Product() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProductname() {
    return productname;
  }

  public void setProductname(String productname) {
    this.productname = productname;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
