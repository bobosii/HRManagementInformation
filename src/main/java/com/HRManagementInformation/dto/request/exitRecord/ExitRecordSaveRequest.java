package com.HRManagementInformation.dto.request.exitRecord;

import java.sql.Date;

public class ExitRecordSaveRequest {
    private Date exitDate;
    private String reason;
    private int userId;

    public ExitRecordSaveRequest() {}

    public ExitRecordSaveRequest(Date exitDate, String reason, int userId) {
        this.exitDate = exitDate;
        this.reason = reason;
        this.userId = userId;
    }

    // Getters & Setters

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
