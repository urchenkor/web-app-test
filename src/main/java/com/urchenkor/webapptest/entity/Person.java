package com.urchenkor.webapptest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public Person() {

    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
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

}