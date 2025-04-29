package com.HRManagementInformation.dto.request.salary;

import java.sql.Date;

public class SalarySaveRequest {
    private double salaryAmount;
    private Date paymentDate;
    private int userId;

    public SalarySaveRequest() {
    }

    public SalarySaveRequest(double salaryAmount, Date paymentDate, int userId) {
        this.salaryAmount = salaryAmount;
        this.paymentDate = paymentDate;
        this.userId = userId;
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
