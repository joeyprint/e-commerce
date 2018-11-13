package shop.ecommerce.ProductService;

import java.io.Serializable;
import java.util.Locale.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String sku;

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    @NotNull
    private double price;

    @NotBlank
    private String detail;

    @NotBlank
    private String thumbnail;

    public Product(String sku, String name, String category, double price, String detail, String thumbnail) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
        this.detail = detail;
        this.thumbnail = thumbnail;
    }

    public Product () {
        super();
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }



}
