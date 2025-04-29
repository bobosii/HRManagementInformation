package com.HRManagementInformation.dto.request.employee;

import java.sql.Date;
import java.sql.Time;
import java.math.BigDecimal;

public class EmployeeAttendanceUpdateRequest {
    private int attendanceId;
    private int userId;
    private Date attendanceDate;
    private Time checkInTime;
    private Time checkOutTime;
    private BigDecimal overtimeHours;

    public EmployeeAttendanceUpdateRequest() {
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Time getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Time checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Time getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Time checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public BigDecimal getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(BigDecimal overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
}