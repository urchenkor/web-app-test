package com.urchenkor.webapptest.repository;

import com.urchenkor.webapptest.entity.Person;
import com.urchenkor.webapptest.entity.StatusEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepos extends CrudRepository<Person, Long> {
    List<Person> findByStatus(StatusEnum status);
}
