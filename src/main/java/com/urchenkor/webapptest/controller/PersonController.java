package com.urchenkor.webapptest.controller;

import com.urchenkor.webapptest.dto.response.PersonCreateResponse;
import com.urchenkor.webapptest.dto.response.PersonGetResponse;
import com.urchenkor.webapptest.dto.response.StatusUpdateResponse;
import com.urchenkor.webapptest.dto.response.StatusUpdateResponseOk;
import com.urchenkor.webapptest.dto.UpdateStatusRequestModel;
import com.urchenkor.webapptest.entity.Person;
import com.urchenkor.webapptest.entity.transport.NewPerson;
import com.urchenkor.webapptest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping()
    public ResponseEntity<PersonCreateResponse> createPerson(@Validated(NewPerson.class)
                                                    @RequestBody Person person) {

        return personService.create(person);
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonGetResponse> getPersonData(@PathVariable Long id) {
        return personService.getPersonData(id);
    }

    @PatchMapping
    public ResponseEntity<StatusUpdateResponse> updateStatus(@Validated
                               @RequestBody UpdateStatusRequestModel model) {
        return personService.updateStatus(model);
    }


}
