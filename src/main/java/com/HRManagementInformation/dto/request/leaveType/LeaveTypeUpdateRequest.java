package com.HRManagementInformation.dto.request.leaveType;

import jakarta.validation.constraints.NotBlank;

public class LeaveTypeUpdateRequest {

    private int id;

    @NotBlank(message = "İzin tipi adı boş olamaz.")
    private String leaveTypeName;

    private String description;

    public LeaveTypeUpdateRequest() {}

    public LeaveTypeUpdateRequest(int id, String leaveTypeName, String description) {
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
