package com.HRManagementInformation.dto.request;

import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public class InterviewUpdateRequest {
    @NotNull(message = "mülakat tarihi boş olamaz")
    private Date interviewDate;

    private String feedback;

    public InterviewUpdateRequest() {
    }

    public InterviewUpdateRequest(Date interviewDate, String feedback) {
        this.interviewDate = interviewDate;
        this.feedback = feedback;
    }

    @NotNull(message = "mülakat tarihi boş olamaz")
    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(@NotNull(message = "mülakat tarihi boş olamaz") Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
} 