package com.urchenkor.webapprest.dto.response.statusUpdate;

import com.urchenkor.webapprest.entity.StatusEnum;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusUpdateResponseOk that = (StatusUpdateResponseOk) o;
        return id.equals(that.id) &&
                beforeUpdateStatus == that.beforeUpdateStatus &&
                afterUpdateStatus == that.afterUpdateStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, beforeUpdateStatus, afterUpdateStatus);
    }
}
