package com.HRManagementInformation.dto.response;

import java.time.LocalDate;

public class LeaveRequestResponse {

    private int id;
    private String userFullName;
    private String leaveTypeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalDays;
    private String status;

    public LeaveRequestResponse() {}

    public LeaveRequestResponse(int id, String userFullName, String leaveTypeName, LocalDate startDate, LocalDate endDate, double totalDays, String status) {
        this.id = id;
        this.userFullName = userFullName;
        this.leaveTypeName = leaveTypeName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDays = totalDays;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(double totalDays) {
        this.totalDays = totalDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
