package com.HRManagementInformation.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class ExitRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date exitDate;
    private String reason;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ExitRecord(){}

    public ExitRecord(int id, Date exitDate, String reason, User user) {
        this.id = id;
        this.exitDate = exitDate;
        this.reason = reason;
        this.user = user;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
