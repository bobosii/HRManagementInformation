package com.HRManagementInformation.dto.request.leaveType;

import jakarta.validation.constraints.NotBlank;

public class LeaveTypeSaveRequest {

    @NotBlank(message = "İzin tipi adı boş olamaz.")
    private String leaveTypeName;

    private String description;

    public LeaveTypeSaveRequest() {}

    public LeaveTypeSaveRequest(String leaveTypeName, String description) {
        this.leaveTypeName = leaveTypeName;
        this.description = description;
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
