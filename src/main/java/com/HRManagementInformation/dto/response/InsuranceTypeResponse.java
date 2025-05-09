package com.HRManagementInformation.dto.response;

public class InsuranceTypeResponse {
    private int insuranceTypeId;
    private String insuranceTypeName;
    private String description;

    public InsuranceTypeResponse(int insuranceTypeId, String insuranceTypeName, String description) {
        this.insuranceTypeId = insuranceTypeId;
        this.insuranceTypeName = insuranceTypeName;
        this.description = description;
    }

    public InsuranceTypeResponse(){}

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

    public int getInsuranceTypeId() {
        return insuranceTypeId;
    }

    public void setInsuranceTypeId(int insuranceTypeId) {
        this.insuranceTypeId = insuranceTypeId;
    }
}
