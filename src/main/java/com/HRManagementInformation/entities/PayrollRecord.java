package com.HRManagementInformation.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class PayrollRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Date payroll_date;
    private double base_salary;
    private double bonuses;
    private double deductions;
    private double netSalary;

    public PayrollRecord(int id, User user, Date payroll_date, double base_salary, double bonuses, double deductions, double netSalary) {
        this.id = id;
        this.user = user;
        this.payroll_date = payroll_date;
        this.base_salary = base_salary;
        this.bonuses = bonuses;
        this.deductions = deductions;
        this.netSalary = netSalary;
    }

    public PayrollRecord() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPayroll_date() {
        return payroll_date;
    }

    public void setPayroll_date(Date payroll_date) {
        this.payroll_date = payroll_date;
    }

    public double getBase_salary() {
        return base_salary;
    }

    public void setBase_salary(double base_salary) {
        this.base_salary = base_salary;
    }

    public double getBonuses() {
        return bonuses;
    }

    public void setBonuses(double bonuses) {
        this.bonuses = bonuses;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
}
