package com.urchenkor.webapptest.dto.response;

import com.urchenkor.webapptest.entity.Person;

public class PersonCreateResponse {
    private Long id;

    public PersonCreateResponse() {}

    public PersonCreateResponse(Person person) {
        this.id = person.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
