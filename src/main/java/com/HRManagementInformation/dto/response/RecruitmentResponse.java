package com.HRManagementInformation.dto.response;

public class RecruitmentResponse {
    private int responseId;
    private String candidateName;
    private String status;
    private String notes;

    public RecruitmentResponse() {
    }

    public RecruitmentResponse(int responseId, String candidateName, String status, String notes) {
        this.responseId = responseId;
        this.candidateName = candidateName;
        this.status = status;
        this.notes = notes;
    }

    public int getResponseId() {
        return responseId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
