package com.example.hibernatehw.PersonRepository;

import com.example.hibernatehw.Persons.Persons;
import com.example.hibernatehw.PrimaryKey.PrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Persons, PrimaryKey> {
    List<Persons> findPersonsByCityOfLiving(String cityOfLiving);
    @Query(value = "select * from Persons p where p.age < :age order by p.age desc", nativeQuery = true)
    List<Persons> findByAgeJPQL(@Param("age") int primaryKey_age);

    Optional<Persons> findPersonsByPrimaryKey_NameAndPrimaryKey_Surname(String primaryKey_name, String primaryKey_surname);
}
