package com.urchenkor.webapprest.controller;

import com.urchenkor.webapprest.dto.response.PersonCreateResponse;
import com.urchenkor.webapprest.dto.response.PersonGet.PersonGetResponse;
import com.urchenkor.webapprest.dto.response.statusUpdate.StatusUpdateResponse;
import com.urchenkor.webapprest.dto.request.UpdateStatusRequestModel;
import com.urchenkor.webapprest.entity.Person;
import com.urchenkor.webapprest.entity.transport.NewPerson;
import com.urchenkor.webapprest.service.PersonService;
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
