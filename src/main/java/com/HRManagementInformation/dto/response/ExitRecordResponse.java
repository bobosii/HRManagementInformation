package com.HRManagementInformation.dto.response;

import java.sql.Date;

public class ExitRecordResponse {
    private int id;
    private Date exitDate;
    private String reason;
    private int userId;
    private String userFullName;

    public ExitRecordResponse() {}

    public ExitRecordResponse(int id, Date exitDate, String reason, int userId, String userFullName) {
        this.id = id;
        this.exitDate = exitDate;
        this.reason = reason;
        this.userId = userId;
        this.userFullName = userFullName;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
}
