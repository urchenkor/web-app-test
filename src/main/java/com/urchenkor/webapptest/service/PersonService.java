package com.urchenkor.webapptest.service;

import com.urchenkor.webapptest.repository.PersonRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {
    PersonRepos personRepos;

    @Autowired
    public PersonService(PersonRepos personRepos) {
        this.personRepos = personRepos;
    }
}
