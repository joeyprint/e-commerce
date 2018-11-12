package shop.ecommerce.ProductService;

import java.util.Locale.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shops")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String sku;
    private String name;
    private Category category;
    private double price;
    private String detail;
    private String thunbnail;


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

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
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

    public String getThunbnail() {
        return this.thunbnail;
    }

    public void setThunbnail(String thunbnail) {
        this.thunbnail = thunbnail;
    }



}
