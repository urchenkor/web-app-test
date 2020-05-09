package com.urchenkor.webapptest.entity;

import com.urchenkor.webapptest.entity.transport.ExistPerson;
import com.urchenkor.webapptest.entity.transport.NewPerson;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue
    @Null(groups = {NewPerson.class})
    @NotNull(groups = {ExistPerson.class})
    private Long id;

    @Null(groups = {ExistPerson.class})
    @NotNull(groups = {NewPerson.class})
    private String name;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    @Null(groups = {NewPerson.class})
    @NotNull(groups = {ExistPerson.class})
    private StatusEnum status;

    @Email
    @Null(groups = {ExistPerson.class})
    @NotNull(groups = {NewPerson.class})
    private String email;

    @Null(groups = {ExistPerson.class})
    @NotNull(groups = {NewPerson.class})
    private String phoneNumber;

    @Null(groups = {NewPerson.class})
    private Long timeStamp;

    public Person() {

    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
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
