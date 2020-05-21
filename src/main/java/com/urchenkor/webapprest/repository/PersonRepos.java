package com.urchenkor.webapprest.repository;

import com.urchenkor.webapprest.entity.Person;
import com.urchenkor.webapprest.entity.StatusEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepos extends CrudRepository<Person, Long> {
    List<Person> findByStatus(StatusEnum status);

    List<Person> findByTimeStampLessThanEqualAndStatus(Long timeStamp, StatusEnum status);
}
