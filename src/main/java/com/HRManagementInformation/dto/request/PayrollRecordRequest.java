package com.HRManagementInformation.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.sql.Date;

public class PayrollRecordRequest {

    @NotNull(message = "Kullanıcı ID'si boş olamaz.")
    @Positive(message = "Kullanıcı ID'si pozitif bir değer olmalıdır.")
    private int userId;

    @NotNull(message = "Maaş tarihi boş olamaz.")
    @PastOrPresent(message = "Maaş tarihi geçmiş veya bugünkü tarih olmalıdır.")
    private Date payrollDate;

    @NotNull(message = "Temel maaş boş olamaz.")
    @Positive(message = "Temel maaş pozitif bir değer olmalıdır.")
    private double baseSalary;

    private double bonuses;
    private double deductions;

    @Positive(message = "Net maaş pozitif bir değer olmalıdır.")
    private double netSalary;

    public PayrollRecordRequest() {}

    public PayrollRecordRequest(int userId, Date payrollDate, double baseSalary, double bonuses, double deductions, double netSalary) {
        this.userId = userId;
        this.payrollDate = payrollDate;
        this.baseSalary = baseSalary;
        this.bonuses = bonuses;
        this.deductions = deductions;
        this.netSalary = netSalary;
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
