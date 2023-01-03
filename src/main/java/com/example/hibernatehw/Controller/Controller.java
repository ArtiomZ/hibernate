package com.example.hibernatehw.Controller;

import com.example.hibernatehw.Persons.Persons;
import com.example.hibernatehw.Repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Controller {
    Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<String> getPersonsByCity(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }
}
