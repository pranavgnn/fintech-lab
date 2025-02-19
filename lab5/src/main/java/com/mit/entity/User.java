package com.mit.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    private UserAddress userAddress;

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

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
}