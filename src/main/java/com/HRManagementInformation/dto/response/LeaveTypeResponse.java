package com.HRManagementInformation.dto.response;

public class LeaveTypeResponse {

    private int id;
    private String leaveTypeName;
    private String description;

    public LeaveTypeResponse() {}

    public LeaveTypeResponse(int id, String leaveTypeName, String description) {
        this.id = id;
        this.leaveTypeName = leaveTypeName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
