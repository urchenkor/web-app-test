package com.urchenkor.webapptest.dto.response.statusUpdate;

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
}
