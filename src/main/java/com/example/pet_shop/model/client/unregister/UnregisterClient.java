package com.example.pet_shop.model.client.unregister;


import javax.persistence.*;

@Entity
@Table(name = "unregister_client")
public class UnregisterClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private long clientId;

    @Column(name = "client_firstname")
    private String clientFirstName;

    @Column(name = "client_email")
    private String clientEmail;

    @Column(name = "client_tel")
    private int clientTel;


    public UnregisterClient() {
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public int getClientTel() {
        return clientTel;
    }

    public void setClientTel(int clientTel) {
        this.clientTel = clientTel;
    }
}
