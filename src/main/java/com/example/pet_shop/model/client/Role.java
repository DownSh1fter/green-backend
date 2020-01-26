package com.example.pet_shop.model.client;


import com.example.pet_shop.model.client.register.RegisterClient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_status")
    private String roleStatus;

    public Role() {
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    Set<RegisterClient> clients;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public Set<RegisterClient> getClients() {
        return clients;
    }

    public void setClients(Set<RegisterClient> clients) {
        this.clients = clients;
    }
}
