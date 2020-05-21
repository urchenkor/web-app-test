package com.urchenkor.webapprest.controller;

import com.urchenkor.webapprest.dto.request.UpdateStatusRequestModel;
import com.urchenkor.webapprest.dto.response.PersonCreateResponse;
import com.urchenkor.webapprest.dto.response.PersonGet.PersonGetResponse;
import com.urchenkor.webapprest.dto.response.PersonGet.PersonGetResponseOk;
import com.urchenkor.webapprest.dto.response.statusUpdate.StatusUpdateResponse;
import com.urchenkor.webapprest.dto.response.statusUpdate.StatusUpdateResponseNotFound;
import com.urchenkor.webapprest.dto.response.statusUpdate.StatusUpdateResponseOk;
import com.urchenkor.webapprest.entity.Person;
import com.urchenkor.webapprest.entity.StatusEnum;
import com.urchenkor.webapprest.service.PersonService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonControllerTests {

    private PersonController subject;

    @Mock
    private PersonService personServiceMock;

    @BeforeAll
    public void setUp() {
        initMocks(this);
        subject = new PersonController(personServiceMock);
    }

    @Test
    @DisplayName("Get method")
    public void getPersonByValidId() {
        Person pers = new Person(1l, "name", StatusEnum.ONLINE, "email@mail.mail", "999-999");
        PersonGetResponse personGetResponse = new PersonGetResponseOk(pers);
        given(personServiceMock.getPersonData(1l))
                .willReturn(new ResponseEntity<>(personGetResponse, HttpStatus.OK));

        ResponseEntity<PersonGetResponse> testResponse = subject.getPersonData(1l);

        Assertions.assertEquals(new ResponseEntity<>(new PersonGetResponseOk(pers), HttpStatus.OK), testResponse);
    }

    @Test
    @DisplayName("Post method")
    public void createPerson() {
        Person pers = new Person(1l, "name", StatusEnum.ONLINE, "email@mail.mail", "999-999");
        PersonCreateResponse personCreateResponse = new PersonCreateResponse(pers);
        given(personServiceMock.create(pers)).
                willReturn(new ResponseEntity<>((personCreateResponse), HttpStatus.CREATED));

        ResponseEntity<PersonCreateResponse> testResponse = subject.createPerson(pers);

        Assertions.assertEquals(new ResponseEntity<>(new PersonCreateResponse(pers), HttpStatus.CREATED),
                testResponse);
    }

    @Test
    @DisplayName("Patch method valid")
    public void updateStatusByValidPerson() {
        UpdateStatusRequestModel model = new UpdateStatusRequestModel(1l, StatusEnum.ONLINE);
        given(personServiceMock.updateStatus(model)).
                willReturn(new ResponseEntity<>(new StatusUpdateResponseOk
                        (1l, StatusEnum.OFFLINE, StatusEnum.ONLINE), HttpStatus.OK));

        ResponseEntity<StatusUpdateResponse> testResponse = subject.updateStatus(model);

        Assertions.assertEquals(new ResponseEntity<>(new StatusUpdateResponseOk
                        (1l, StatusEnum.OFFLINE, StatusEnum.ONLINE), HttpStatus.OK), testResponse);
    }

    @Test
    @DisplayName("Patch method invalid")
    public void updateStatusByInvalidPerson() {
        UpdateStatusRequestModel model = new UpdateStatusRequestModel(null, StatusEnum.ONLINE);
        given(personServiceMock.updateStatus(model)).
                willReturn(new ResponseEntity<>(new StatusUpdateResponseNotFound("person not found")
                        , HttpStatus.NOT_FOUND));

        ResponseEntity<StatusUpdateResponse> testResponse = subject.updateStatus(model);

        Assertions.assertEquals(new ResponseEntity<>(new StatusUpdateResponseNotFound("person not found"),
                HttpStatus.NOT_FOUND), testResponse);
    }

}
