package com.urchenkor.webapprest.service;

import com.urchenkor.webapprest.dto.request.UpdateStatusRequestModel;
import com.urchenkor.webapprest.dto.response.PersonCreateResponse;
import com.urchenkor.webapprest.dto.response.PersonGet.PersonGetResponse;
import com.urchenkor.webapprest.dto.response.PersonGet.PersonGetResponseNotFound;
import com.urchenkor.webapprest.dto.response.PersonGet.PersonGetResponseOk;
import com.urchenkor.webapprest.dto.response.statusUpdate.StatusUpdateResponse;
import com.urchenkor.webapprest.dto.response.statusUpdate.StatusUpdateResponseNotFound;
import com.urchenkor.webapprest.dto.response.statusUpdate.StatusUpdateResponseOk;
import com.urchenkor.webapprest.entity.Person;
import com.urchenkor.webapprest.entity.StatusEnum;
import com.urchenkor.webapprest.repository.PersonRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonService {
    private PersonRepos personRepos;


    @Autowired
    public PersonService(PersonRepos personRepos) {
        this.personRepos = personRepos;
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
        if (optional.isPresent()) {
            return new ResponseEntity<>(new PersonGetResponseOk(optional.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new PersonGetResponseNotFound("person not found"), HttpStatus.NOT_FOUND);
        }
    }


}
