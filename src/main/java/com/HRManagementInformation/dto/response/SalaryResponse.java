package com.HRManagementInformation.dto.response;

import java.sql.Date;

public class SalaryResponse {
    private int id;
    private double salaryAmount;
    private Date paymentDate;
    private int userId;
    private String userFullName;

    public SalaryResponse() {
    }

    public SalaryResponse(int id, double salaryAmount, Date paymentDate, int userId, String userFullName) {
        this.id = id;
        this.salaryAmount = salaryAmount;
        this.paymentDate = paymentDate;
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

    public double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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
