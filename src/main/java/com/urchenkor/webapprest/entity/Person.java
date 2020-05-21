package com.urchenkor.webapprest.entity;

import com.urchenkor.webapprest.entity.transport.NewPerson;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Objects;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue
    @Null(groups = {NewPerson.class})
    private Long id;

    @NotNull(groups = {NewPerson.class})
    private String name;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    @Null(groups = {NewPerson.class})
    private StatusEnum status;

    @Email
    @NotNull(groups = {NewPerson.class})
    private String email;

    @NotNull(groups = {NewPerson.class})
    private String phoneNumber;

    @Null(groups = {NewPerson.class})
    private Long timeStamp;

    public Person() {

    }

    public Person(Long id, String name, StatusEnum status, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) &&
                name.equals(person.name) &&
                status == person.status &&
                email.equals(person.email) &&
                phoneNumber.equals(person.phoneNumber) &&
                timeStamp.equals(person.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, email, phoneNumber, timeStamp);
    }
}
