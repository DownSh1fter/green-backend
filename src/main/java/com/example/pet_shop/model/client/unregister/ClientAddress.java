package com.example.pet_shop.model.client.unregister;


import javax.persistence.*;

@Entity
@Table(name = "unregister_client_address")
public class ClientAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_address_id")
    private long addressId;

    @Column(name = "client_address_country")
    private String addressCountry;

    @Column(name = "client_city")
    private String addressCity;

    @Column(name = "client_street")
    private String addressStreet;

    @Column(name = "client_address_home_number")
    private String addressHome;

    @Column(name = "client_address_flat_number")
    private String addressFlat;

    public ClientAddress() {
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressHome() {
        return addressHome;
    }

    public void setAddressHome(String addressHome) {
        this.addressHome = addressHome;
    }

    public String getAddressFlat() {
        return addressFlat;
    }

    public void setAddressFlat(String addressFlat) {
        this.addressFlat = addressFlat;
    }
}
