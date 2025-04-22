package com.HRManagementInformation.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.sql.Date;

public class InterviewSaveRequest {
    @Positive(message = "id pozitif bir değer olmak zorunda")
    @NotNull(message = "id değeri null veya boş olamaz")
    private int interviewId;

    @NotNull(message = "recruitment id değeri null veya boş olamaz")
    private int recruitmentId;

    @NotNull(message = "mülakat tarihi boş olamaz")
    private Date interviewDate;

    private String feedback;

    public InterviewSaveRequest() {
    }

    public InterviewSaveRequest(int interviewId, int recruitmentId, Date interviewDate, String feedback) {
        this.interviewId = interviewId;
        this.recruitmentId = recruitmentId;
        this.interviewDate = interviewDate;
        this.feedback = feedback;
    }

    @Positive(message = "id pozitif bir değer olmak zorunda")
    @NotNull(message = "id değeri null veya boş olamaz")
    public int getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(@Positive(message = "id pozitif bir değer olmak zorunda") 
                             @NotNull(message = "id değeri null veya boş olamaz") int interviewId) {
        this.interviewId = interviewId;
    }

    @NotNull(message = "recruitment id değeri null veya boş olamaz")
    public int getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(@NotNull(message = "recruitment id değeri null veya boş olamaz") int recruitmentId) {
        this.recruitmentId = recruitmentId;
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