package com.example.hibernatehw.Controller;

import com.example.hibernatehw.Body.Body;
import com.example.hibernatehw.PersonRepository.PersonRepository;
import com.example.hibernatehw.Persons.Persons;
import com.example.hibernatehw.PrimaryKey.PrimaryKey;
import com.example.hibernatehw.Repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
public class Controller {

    final PersonRepository personRepository;

    public Controller(Repository repository, PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam String city) {
        return personRepository.findPersonsByCityOfLiving(city);
    }

    @GetMapping("/persons/by-age")
    public List<Persons> getPersonsByAge(@RequestParam int age) {
        return personRepository.findByAgeJPQL(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<Persons> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findPersonsByPrimaryKey_NameAndPrimaryKey_Surname(name, surname);
    }

    @PostMapping("/new")
    public String postPerson(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam int age,
                             @RequestParam String phoneNumber,
                             @RequestParam String city) {
        Persons persons = new Persons(new PrimaryKey(name, surname, age), phoneNumber, city);
        personRepository.saveAndFlush(persons);
        return persons.toString();
    }

    @DeleteMapping("/delete")
    public String deletePerson(@RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam int age) {
        personRepository.deleteById(new PrimaryKey(name, surname, age));
        return "A person named " + name + " " + surname + " has been removed";
    }

    @PatchMapping("update")
    public String updatePerson(@RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam int age,
                               @RequestBody Body body) {

        Persons persons;
        Optional<Persons> opt = personRepository.findById(new PrimaryKey(name, surname, age));

        if (opt.isPresent()) {
            personRepository.deleteById(new PrimaryKey(name, surname, age));
            persons = opt.get();
            persons.setPrimaryKey(new PrimaryKey(body.getName(), body.getSurname(), body.getAge()));
            persons.setPhoneNumber(body.getPhoneNumber());
            persons.setCityOfLiving(body.getCityOfLiving());
        } else {
            return "user not found";
        }
        personRepository.saveAndFlush(persons);

        return persons.toString();
    }
}
