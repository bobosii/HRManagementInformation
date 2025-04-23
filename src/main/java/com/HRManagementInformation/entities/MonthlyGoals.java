package com.HRManagementInformation.entities;

import jakarta.persistence.*;

@Entity
public class MonthlyGoals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goalId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int year;
    private int month;
    private String targetDescription;
    private int goalValue;
    private String status;

    public MonthlyGoals() {
    }

    public MonthlyGoals(int goalId, User user, int year, int month, String targetDescription, int goalValue, String status) {
        this.goalId = goalId;
        this.user = user;
        this.year = year;
        this.month = month;
        this.targetDescription = targetDescription;
        this.goalValue = goalValue;
        this.status = status;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getTargetDescription() {
        return targetDescription;
    }

    public void setTargetDescription(String targetDescription) {
        this.targetDescription = targetDescription;
    }

    public int getGoalValue() {
        return goalValue;
    }

    public void setGoalValue(int goalValue) {
        this.goalValue = goalValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}