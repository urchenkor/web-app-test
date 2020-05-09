package com.urchenkor.webapptest.dto.response;

import com.urchenkor.webapptest.entity.StatusEnum;

public class StatusUpdateResponseOk implements StatusUpdateResponse{
    private Long id;
    private StatusEnum beforeUpdateStatus;
    private StatusEnum afterUpdateStatus;

    public StatusUpdateResponseOk() {}

    public StatusUpdateResponseOk(Long id, StatusEnum beforeUpdateStatus, StatusEnum afterUpdateStatus) {
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
