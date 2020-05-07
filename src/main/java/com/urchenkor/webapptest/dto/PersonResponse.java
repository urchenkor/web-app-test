package com.urchenkor.webapptest.dto;

import com.urchenkor.webapptest.entity.Person;

public class PersonResponse {
    private Long id;

    public PersonResponse() {}

    public PersonResponse(Person person) {
        this.id = person.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
