package th.in.shopdi.FrontendService.model;

public class Product {
  private String productname;
  private double price;
  private String imageURL;

  public Product(String productname, double price, String imageURL) {
    this.productname = productname;
    this.price = price;
    this.imageURL = imageURL;
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
}