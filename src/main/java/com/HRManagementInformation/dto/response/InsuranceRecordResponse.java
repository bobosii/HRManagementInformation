package com.HRManagementInformation.dto.response;

import java.sql.Date;

public class InsuranceRecordResponse {
    private int insuranceId;
    private int userId;
    private int insuranceTypeId;
    private Date startDate;
    private Date endDate;
    private String insuranceNumber;

    public InsuranceRecordResponse(){}

    public InsuranceRecordResponse(int insuranceId, int userId, int insuranceTypeId, Date startDate, Date endDate, String insuranceNumber) {
        this.insuranceId = insuranceId;
        this.userId = userId;
        this.insuranceTypeId = insuranceTypeId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInsuranceTypeId() {
        return insuranceTypeId;
    }

    public void setInsuranceTypeId(int insuranceTypeId) {
        this.insuranceTypeId = insuranceTypeId;
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
