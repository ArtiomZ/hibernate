package com.example.hibernatehw;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    EntityManager entityManager;

    public String getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Persons p\n" +
                "where p.cityOfLiving = :city", Persons.class);
        query.setParameter("city", city);
        return query.getResultList().toString();
    }


}
