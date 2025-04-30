package com.HRManagementInformation.dto.request.exitRecord;

import java.sql.Date;

public class ExitRecordUpdateRequest {
    private int id;
    private Date exitDate;
    private String reason;

    public ExitRecordUpdateRequest() {}

    public ExitRecordUpdateRequest(int id, Date exitDate, String reason) {
        this.id = id;
        this.exitDate = exitDate;
        this.reason = reason;
    }

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
