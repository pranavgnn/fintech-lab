package com.mit.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String gender;

    @OneToMany(cascade = CascadeType.ALL)
    private List<UserAddress> userAddresses;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long newUserId) {
        this.userId = newUserId;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String newName) {
    	this.name = newName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String newGender) {
        this.gender = newGender;
    }

    public List<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<UserAddress> newUserAddresses) {
        this.userAddresses = newUserAddresses;
    }
}