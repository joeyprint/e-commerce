package shop.ecommerce.AddressService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")

public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String address;
    private String provinc;
    private String district;
    private String zipcode;
    private String telNo;

    public Address(String address, String provinc, String district, String zipcode, String telNo) {
        this.address = address;
        this.provinc = provinc;
        this.district = district;
        this.zipcode = zipcode;
        this.telNo = telNo;
    }

    public Address() {
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvinc() {
        return this.provinc;
    }

    public void setProvinc(String provinc) {
        this.provinc = provinc;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTelNo() {
        return this.telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
}
