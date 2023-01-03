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

    @Override
    public String toString() {
        return "Persons{" +
                "primaryKey=" + primaryKey +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }
}
