package com.urchenkor.webapprest.dto.request;

import com.urchenkor.webapprest.entity.StatusEnum;

import javax.validation.constraints.NotNull;

public class UpdateStatusRequestModel {
    @NotNull
    private Long id;

    @NotNull
    private StatusEnum status;

    public UpdateStatusRequestModel() {}

    public UpdateStatusRequestModel(Long id, StatusEnum status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
