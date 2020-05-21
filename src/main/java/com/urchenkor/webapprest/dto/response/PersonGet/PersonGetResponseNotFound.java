package com.urchenkor.webapprest.dto.response.PersonGet;

import java.util.Objects;

public class PersonGetResponseNotFound implements PersonGetResponse {
    private String message;

    public PersonGetResponseNotFound(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonGetResponseNotFound that = (PersonGetResponseNotFound) o;
        return message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
