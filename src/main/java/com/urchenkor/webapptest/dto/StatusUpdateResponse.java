package com.urchenkor.webapptest.dto;

import com.urchenkor.webapptest.entity.StatusEnum;

public class StatusUpdateResponse {
    private Long id;
    private StatusEnum beforeUpdateStatus;
    private StatusEnum afterUpdateStatus;

    public StatusUpdateResponse() {}

    public StatusUpdateResponse(Long id, StatusEnum beforeUpdateStatus, StatusEnum afterUpdateStatus) {
        this.id = id;
        this.beforeUpdateStatus = beforeUpdateStatus;
        this.afterUpdateStatus = afterUpdateStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusEnum getBeforeUpdateStatus() {
        return beforeUpdateStatus;
    }

    public void setBeforeUpdateStatus(StatusEnum beforeUpdateStatus) {
        this.beforeUpdateStatus = beforeUpdateStatus;
    }

    public StatusEnum getAfterUpdateStatus() {
        return afterUpdateStatus;
    }

    public void setAfterUpdateStatus(StatusEnum afterUpdateStatus) {
        this.afterUpdateStatus = afterUpdateStatus;
    }
}
