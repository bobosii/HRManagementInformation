package com.HRManagementInformation.dto.response;


import com.HRManagementInformation.business.abstracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

public class PayrollRecordsResponse {
    private int id;
    private int userId;
    private Date payrollDate;
    private double baseSalary;
    private double bonuses;
    private double deductions;
    private double netSalary;

    public PayrollRecordsResponse() {}

    public PayrollRecordsResponse(int id, int userId, Date payrollDate,
                                  double baseSalary, double bonuses, double deductions, double netSalary) {
        this.id = id;
        this.userId = userId;
        this.payrollDate = payrollDate;
        this.baseSalary = baseSalary;
        this.bonuses = bonuses;
        this.deductions = deductions;
        this.netSalary = netSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getPayrollDate() {
        return payrollDate;
    }

    public void setPayrollDate(Date payrollDate) {
        this.payrollDate = payrollDate;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
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
