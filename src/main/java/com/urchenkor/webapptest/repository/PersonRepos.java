package com.urchenkor.webapptest.repository;

import com.urchenkor.webapptest.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepos extends CrudRepository<Person, Long> {
    Person findByName(String name);


}
