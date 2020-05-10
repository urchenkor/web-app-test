package com.urchenkor.webapptest.service;

import com.urchenkor.webapptest.dto.response.*;
import com.urchenkor.webapptest.dto.request.UpdateStatusRequestModel;
import com.urchenkor.webapptest.dto.response.statusUpdate.StatusUpdateResponse;
import com.urchenkor.webapptest.dto.response.statusUpdate.StatusUpdateResponseNotFound;
import com.urchenkor.webapptest.dto.response.statusUpdate.StatusUpdateResponseOk;
import com.urchenkor.webapptest.entity.Person;
import com.urchenkor.webapptest.entity.StatusEnum;
import com.urchenkor.webapptest.repository.PersonRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonService {
    private PersonRepos personRepos;
    private StatusRefreshService statusRefreshService;


    @Autowired
    public PersonService(PersonRepos personRepos, StatusRefreshService statusRefreshService) {
        this.personRepos = personRepos;
        this.statusRefreshService = statusRefreshService;
    }

    public ResponseEntity<PersonCreateResponse> create(Person person) {
        person.setStatus(StatusEnum.ONLINE);
        person.setTimeStamp(System.currentTimeMillis());
        personRepos.save(person);
        return new ResponseEntity<>(new PersonCreateResponse(person), HttpStatus.CREATED);
    }

    public ResponseEntity<StatusUpdateResponse> updateStatus(UpdateStatusRequestModel model) {

        StatusEnum beforeStatus;
        StatusEnum afterStatus;
        Optional<Person> personFromDb = personRepos.findById(model.getId());
        if (!personFromDb.isPresent()) {
            return new ResponseEntity<>(new StatusUpdateResponseNotFound("person not found"), HttpStatus.NOT_FOUND);
        }
        else {
            Person person1 = personFromDb.get();

            afterStatus = model.getStatus();
            beforeStatus = person1.getStatus();

            person1.setStatus(afterStatus);
            if (afterStatus.equals(StatusEnum.ONLINE)) {
                person1.setTimeStamp(System.currentTimeMillis());
            }
            personRepos.save(person1);
            return new ResponseEntity<>(new StatusUpdateResponseOk(person1.getId(), beforeStatus,
                    afterStatus), HttpStatus.OK);
        }
    }

    public ResponseEntity<PersonGetResponse> getPersonData(Long id) {
        Optional<Person> optional = personRepos.findById(id);
        Person personFromDb = optional.isPresent() ? optional.get() : null;
        return new ResponseEntity<>(new PersonGetResponse(personFromDb), HttpStatus.OK);
    }


}
