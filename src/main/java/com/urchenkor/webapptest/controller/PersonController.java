package com.urchenkor.webapptest.controller;

import com.urchenkor.webapptest.dto.PersonCreateResponse;
import com.urchenkor.webapptest.dto.StatusUpdateResponse;
import com.urchenkor.webapptest.entity.Person;
import com.urchenkor.webapptest.repository.PersonRepos;
import com.urchenkor.webapptest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    private PersonRepos personRepos;
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService, PersonRepos personRepos) {
        this.personService = personService;
        this.personRepos = personRepos;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PersonCreateResponse> createPerson(@Validated @RequestBody Person person) {

        return personService.create(person);
    }

    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable Long id) {
        Optional<Person> person = personRepos.findById(id);

        return person.isPresent() ? person.get() : null;
    }

    @PutMapping("/update")
    public ResponseEntity<StatusUpdateResponse> updateStatus(@RequestBody Person person) {
        return personService.updateStatus(person);
    }

}
