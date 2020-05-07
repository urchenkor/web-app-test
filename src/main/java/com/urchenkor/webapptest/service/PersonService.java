package com.urchenkor.webapptest.service;

import com.urchenkor.webapptest.entity.Person;
import com.urchenkor.webapptest.entity.StatusEnum;
import com.urchenkor.webapptest.repository.PersonRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonService {
    PersonRepos personRepos;

    @Autowired
    public PersonService(PersonRepos personRepos) {
        this.personRepos = personRepos;
    }

    public ResponseEntity<String> create(Person person) {
        person.setStatus(StatusEnum.ONLINE);
        personRepos.save(person);
        return new ResponseEntity<>("Id = " + person.getId(), HttpStatus.CREATED);
    }
}
