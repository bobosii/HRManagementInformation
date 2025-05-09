package com.HRManagementInformation.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class InsuranceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int insuranceTypeId;

    private String insuranceTypeName;

    private String description;

    @OneToMany(mappedBy = "insuranceType")
    private List<InsuranceRecord> insuranceRecords;

    public InsuranceType() {}

    public InsuranceType(int insuranceTypeId, String insuranceTypeName, String description, List<InsuranceRecord> insuranceRecords) {
        this.insuranceTypeId = insuranceTypeId;
        this.insuranceTypeName = insuranceTypeName;
        this.description = description;
        this.insuranceRecords = insuranceRecords;
    }

    public int getInsuranceTypeId() {
        return insuranceTypeId;
    }

    public void setInsuranceTypeId(int insuranceTypeId) {
        this.insuranceTypeId = insuranceTypeId;
    }

    public String getInsuranceTypeName() {
        return insuranceTypeName;
    }

    public void setInsuranceTypeName(String insuranceTypeName) {
        this.insuranceTypeName = insuranceTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InsuranceRecord> getInsuranceRecords() {
        return insuranceRecords;
    }

    public void setInsuranceRecords(List<InsuranceRecord> insuranceRecords) {
        this.insuranceRecords = insuranceRecords;
    }
}