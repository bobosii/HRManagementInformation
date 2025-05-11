package com.HRManagementInformation.dto.request.insuranceRecord;

import java.sql.Date;

public class InsuranceRecordSaveRequest {

    private int userId;
    private int insuranceTypeId;
    private Date startDate;
    private Date endDate;
    private String insuranceNumber;

    public InsuranceRecordSaveRequest() {}

    public InsuranceRecordSaveRequest(int userId, int insuranceTypeId, Date startDate, Date endDate, String insuranceNumber) {
        this.userId = userId;
        this.insuranceTypeId = insuranceTypeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.insuranceNumber = insuranceNumber;
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
