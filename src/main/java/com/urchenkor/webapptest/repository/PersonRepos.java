package com.urchenkor.webapptest.repository;

import com.urchenkor.webapptest.entity.Person;
import com.urchenkor.webapptest.entity.StatusEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface PersonRepos extends CrudRepository<Person, Long> {
    Person findByName(String name);
    List<Person> findByStatus(StatusEnum status);
}
