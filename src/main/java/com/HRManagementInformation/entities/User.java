package com.HRManagementInformation.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String tcNo;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "user")
    private List<InsuranceRecord> insuranceRecords;

    @OneToMany(mappedBy = "user")
    private List<PayrollRecord> payrollRecords;

    @OneToMany(mappedBy = "user")
    private List<Salary> salaries;

    @OneToOne(mappedBy = "user")
    private ExitRecord exitRecord;

    private Date hireDate;
    private Date birthDate;

    public User() {}

    public User(int id, String firstName, String lastName, String email, String phone, String password, String tcNo, Role role, Department department, PayrollRecord payrollRecord, List<PayrollRecord> payrollRecord1, List<Salary> salaries, ExitRecord exitRecord, Date hireDate, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.tcNo = tcNo;
        this.role = role;
        this.department = department;
        this.payrollRecords = payrollRecord1;
        this.salaries = salaries;
        this.exitRecord = exitRecord;
        this.hireDate = hireDate;
        this.birthDate = birthDate;
    }

    public ExitRecord getExitRecord() {
        return exitRecord;
    }

    public void setExitRecord(ExitRecord exitRecord) {
        this.exitRecord = exitRecord;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<PayrollRecord> getPayrollRecords() {
        return payrollRecords;
    }

    public void setPayrollRecords(List<PayrollRecord> payrollRecords) {
        this.payrollRecords = payrollRecords;
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
