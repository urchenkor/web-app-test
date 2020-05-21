package com.urchenkor.webapprest.dto.response.PersonGet;

import com.urchenkor.webapprest.entity.Person;
import com.urchenkor.webapprest.entity.StatusEnum;

import java.util.Objects;

public class PersonGetResponseOk implements PersonGetResponse{
    private Long id;
    private String name;
    private StatusEnum status;
    private String email;
    private String phoneNumber;

    public PersonGetResponseOk(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.status = person.getStatus();
        this.email = person.getEmail();
        this.phoneNumber = person.getPhoneNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonGetResponseOk that = (PersonGetResponseOk) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                status == that.status &&
                email.equals(that.email) &&
                phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, email, phoneNumber);
    }
}
