package com.example.hibernatehw.Persons;

import com.example.hibernatehw.PrimaryKey.PrimaryKey;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Entity
public class Persons {
    @EmbeddedId
    @Column(nullable = false)
    private PrimaryKey primaryKey;
    private String phoneNumber;
    private String cityOfLiving;

    public Persons(PrimaryKey primaryKey, String phoneNumber, String cityOfLiving) {
        this.primaryKey = primaryKey;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
    }

    public Persons() {

    }

    public void setPrimaryKey(PrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "primaryKey=" + primaryKey +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }
}
