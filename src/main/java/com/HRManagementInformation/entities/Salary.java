package com.HRManagementInformation.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double salaryAmount;
    private Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Salary(int id, double salaryAmount, Date paymentDate, User user) {
        this.id = id;
        this.salaryAmount = salaryAmount;
        this.paymentDate = paymentDate;
        this.user = user;
    }

    public Salary(){}

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
