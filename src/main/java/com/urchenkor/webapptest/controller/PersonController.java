package com.urchenkor.webapptest.controller;

import com.urchenkor.webapptest.dto.PersonCreateResponse;
import com.urchenkor.webapptest.dto.PersonGetResponse;
import com.urchenkor.webapptest.dto.StatusUpdateResponse;
import com.urchenkor.webapptest.entity.Person;
import com.urchenkor.webapptest.entity.transport.ExistPerson;
import com.urchenkor.webapptest.entity.transport.NewPerson;
import com.urchenkor.webapptest.repository.PersonRepos;
import com.urchenkor.webapptest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonRepos personRepos;
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService, PersonRepos personRepos) {
        this.personService = personService;
        this.personRepos = personRepos;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PersonCreateResponse> createPerson(@Validated(NewPerson.class)
                                                    @RequestBody Person person) {

        return personService.create(person);
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonGetResponse> getPersonData(@PathVariable Long id) {
        return personService.getPersonData(id);
    }

    @PatchMapping
    public ResponseEntity<StatusUpdateResponse> updateStatus(@Validated(ExistPerson.class)
                                                   @RequestBody Person person) {
        return personService.updateStatus(person);
    }


}
