package com.HRManagementInformation.dto.response;

import java.sql.Date;

public class SalaryResponse {
    private int id;
    private double salaryAmount;
    private Date paymentDate;
    private UserResponse user;

    public SalaryResponse() {
    }

    public SalaryResponse(int id, double salaryAmount, Date paymentDate, UserResponse user) {
        this.id = id;
        this.salaryAmount = salaryAmount;
        this.paymentDate = paymentDate;
        this.user = user;
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

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
