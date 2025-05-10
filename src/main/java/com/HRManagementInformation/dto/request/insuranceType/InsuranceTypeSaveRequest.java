package com.HRManagementInformation.dto.request.insuranceType;

public class InsuranceTypeSaveRequest {

    private String insuranceTypeName;
    private String description;

    public InsuranceTypeSaveRequest() {}

    public InsuranceTypeSaveRequest(String insuranceTypeName, String description) {
        this.insuranceTypeName = insuranceTypeName;
        this.description = description;
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
}
