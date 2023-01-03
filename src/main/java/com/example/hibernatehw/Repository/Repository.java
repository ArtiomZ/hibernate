package com.example.hibernatehw.Repository;

import com.example.hibernatehw.Persons.Persons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    EntityManager entityManager;

    public List<String> getPersonsByCity(String city) {
        List<String> list = new ArrayList<>();
        Query query = entityManager.createQuery("select p from Persons p\n" +
                "where p.cityOfLiving = :city", Persons.class);
        query.setParameter("city", city);
        List resultList = query.getResultList();
        for (Object o : resultList) {
            list.add(o.toString());
        }
        return list;

    }

}
