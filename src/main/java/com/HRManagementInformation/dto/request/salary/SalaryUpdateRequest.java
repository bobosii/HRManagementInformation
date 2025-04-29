package com.HRManagementInformation.dto.request.salary;

import java.sql.Date;

public class SalaryUpdateRequest {
    private int id;
    private double salaryAmount;
    private Date paymentDate;
    private int userId;

    public SalaryUpdateRequest() {
    }

    public SalaryUpdateRequest(int id, double salaryAmount, Date paymentDate, int userId) {
        this.id = id;
        this.salaryAmount = salaryAmount;
        this.paymentDate = paymentDate;
        this.userId = userId;
    }

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
}
