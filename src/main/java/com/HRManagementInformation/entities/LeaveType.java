package com.HRManagementInformation.entities;

import jakarta.persistence.*;

@Entity
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String leaveTypeName;
    private String description;

    public LeaveType() {}

    public LeaveType(int id, String leaveTypeName, String description) {
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
