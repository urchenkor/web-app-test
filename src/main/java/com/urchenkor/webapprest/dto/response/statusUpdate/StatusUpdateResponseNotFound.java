package com.urchenkor.webapprest.dto.response.statusUpdate;

import java.util.Objects;

public class StatusUpdateResponseNotFound implements StatusUpdateResponse{
    private String Message;

    public StatusUpdateResponseNotFound() {}

    public StatusUpdateResponseNotFound(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusUpdateResponseNotFound that = (StatusUpdateResponseNotFound) o;
        return Message.equals(that.Message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Message);
    }
}
