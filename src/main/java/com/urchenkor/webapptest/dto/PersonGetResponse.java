package com.urchenkor.webapptest.dto;

import com.urchenkor.webapptest.entity.Person;
import com.urchenkor.webapptest.entity.StatusEnum;

public class PersonGetResponse {
    private Long id;
    private String name;
    private StatusEnum status;
    private String email;
    private String phoneNumber;

    public PersonGetResponse() {
    }

    public PersonGetResponse(Person person) {
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
}
