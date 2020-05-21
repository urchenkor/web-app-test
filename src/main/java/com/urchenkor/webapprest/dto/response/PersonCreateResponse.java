package com.urchenkor.webapprest.dto.response;

import com.urchenkor.webapprest.entity.Person;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonCreateResponse that = (PersonCreateResponse) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
