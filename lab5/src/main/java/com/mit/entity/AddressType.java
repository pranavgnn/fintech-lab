package com.mit.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "ADDRESS_TYPE")
public class AddressType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    private String type;

    public Long getTypeId() {
        return typeId;
    }
    
    public void setTypeId(Long newTypeId) {
        this.typeId = newTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String newType) {
        type = newType;
    }
}