package shop.ecommerce.UserService;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name="tel_no")
    private String telNo;

    public User(@NotBlank String name, @NotBlank String surname, @NotBlank String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public User() {
        super();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
}
