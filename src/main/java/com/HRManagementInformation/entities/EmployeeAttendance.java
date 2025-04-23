package com.HRManagementInformation.entities;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class EmployeeAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Date attendanceDate;
    private Time checkInTime;
    private Time checkOutTime;
    private int overtimeHours;

    public EmployeeAttendance() {
    }

    public EmployeeAttendance(int attendanceId, User user, Date attendanceDate, Time checkInTime, Time checkOutTime, int overtimeHours) {
        this.attendanceId = attendanceId;
        this.user = user;
        this.attendanceDate = attendanceDate;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.overtimeHours = overtimeHours;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
}