package com.example.hibernatehw.PrimaryKey;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class PrimaryKey implements Serializable {

    private String name;
    private String surname;
    private int age;

    @Override
    public String toString() {
        return "PrimaryKey{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
