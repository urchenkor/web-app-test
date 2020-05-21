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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonServiceTests {

    private PersonService subject;

    @Mock
    private PersonRepos personReposMock;

    @BeforeAll
    public void setUp() {
        initMocks(this);
        subject = new PersonService(personReposMock);
    }

    @Test
    public void createPerson() throws Exception {
        Person pers = new Person(1l, "name", StatusEnum.ONLINE, "emai@mail.mail", "777-777");

        ResponseEntity<PersonCreateResponse> testResponse = new ResponseEntity<>(new PersonCreateResponse(pers), HttpStatus.CREATED);

        Assertions.assertEquals(new ResponseEntity<>(new PersonCreateResponse(pers), HttpStatus.CREATED),
                testResponse);
    }

    @Test
    public void updatePersonByValidPersonId() throws Exception {
        UpdateStatusRequestModel model = new UpdateStatusRequestModel(1l, StatusEnum.ONLINE);
        Person pers = new Person(1l, "name", StatusEnum.OFFLINE, "emai@mail.mail", "777-777");
        given(personReposMock.findById(1l)).willReturn(Optional.of(pers));

        ResponseEntity<StatusUpdateResponse> testResponse = subject.updateStatus(model);

        Assertions.assertEquals(new ResponseEntity<>(new StatusUpdateResponseOk(1l, StatusEnum.OFFLINE, StatusEnum.ONLINE),
                HttpStatus.OK), testResponse);
    }

    @Test
    public void updatePersonByInvalidPersonId() throws Exception {
        UpdateStatusRequestModel model = new UpdateStatusRequestModel(1l, StatusEnum.ONLINE);
        given(personReposMock.findById(1l)).willReturn(Optional.empty());

        ResponseEntity<StatusUpdateResponse> testResponse = subject.updateStatus(model);

        Assertions.assertEquals(new ResponseEntity<>(new StatusUpdateResponseNotFound("person not found"),
                HttpStatus.NOT_FOUND), testResponse);
    }

    @Test
    public void getPersonDataByValidId() throws Exception {
        Person pers = new Person(1l, "name", StatusEnum.OFFLINE, "emai@mail.mail", "777-777");
        given(personReposMock.findById(1l)).willReturn(Optional.of(pers));

        ResponseEntity<PersonGetResponse> testResponse = subject.getPersonData(1l);

        Assertions.assertEquals(new ResponseEntity<>(
                (new PersonGetResponseOk(pers)), HttpStatus.OK), testResponse);
    }

    @Test
    public void getPersonDataByInvalidId() throws Exception {
        given(personReposMock.findById(1l)).willReturn(Optional.empty());

        ResponseEntity<PersonGetResponse> testResponse = subject.getPersonData(1l);

        Assertions.assertEquals(new ResponseEntity<>(
                (new PersonGetResponseNotFound("person not found")), HttpStatus.NOT_FOUND), testResponse);
    }

}
