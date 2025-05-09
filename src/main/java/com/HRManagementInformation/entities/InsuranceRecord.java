package com.HRManagementInformation.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class InsuranceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int insuranceId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "insurance_type_id")
    private InsuranceType insuranceType;

    private Date startDate;
    private Date endDate;

    @Column(unique = true)
    private String insuranceNumber;

    public InsuranceRecord() {}

    public InsuranceRecord(int insuranceId, User user, InsuranceType insuranceType,
                           Date startDate, Date endDate, String insuranceNumber) {
        this.insuranceId = insuranceId;
        this.user = user;
        this.insuranceType = insuranceType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.insuranceNumber = insuranceNumber;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
}
