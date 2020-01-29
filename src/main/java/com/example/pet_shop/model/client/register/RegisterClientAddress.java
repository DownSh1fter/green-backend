package com.example.pet_shop.model.client.register;

import com.example.pet_shop.model.client.unregister.UnregisterClient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "register_client_address")
public class RegisterClientAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_client_address_id")
    private long addressId;

    @Column(name = "r_client_address_country")
    private String addressCountry;

    @Column(name = "r_client_city")
    private String addressCity;

    @Column(name = "r_client_street")
    private String addressStreet;

    @Column(name = "r_client_address_home_number")
    private String addressHome;

    @Column(name = "r_client_address_flat_number")
    private int addressFlat;

    @JsonIgnore
    @OneToMany(mappedBy = "registerClientAddress")
    private List<RegisterClient> registerClients;

    public RegisterClientAddress() {
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

    public int getAddressFlat() {
        return addressFlat;
    }

    public void setAddressFlat(int addressFlat) {
        this.addressFlat = addressFlat;
    }

    public List<RegisterClient> getRegisterClients() {
        return registerClients;
    }

    public void setRegisterClients(List<RegisterClient> registerClients) {
        this.registerClients = registerClients;
    }

}
