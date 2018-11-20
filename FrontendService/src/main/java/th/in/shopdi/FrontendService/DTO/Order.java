package th.in.shopdi.FrontendService.DTO;

import java.util.Date;

public class Order {
    private long id;
    private Product product;
    private Date createAt;
    private User user;

    public Order() {
    }

    public Order(long id, Product product, Date createAt, User user) {
        this.id = id;
        this.product = product;
        this.createAt = createAt;
        this.user = user;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
