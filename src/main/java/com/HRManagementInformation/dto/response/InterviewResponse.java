package com.HRManagementInformation.dto.response;

import java.sql.Date;

public class InterviewResponse {
    private int interviewId;
    private Date interviewDate;
    private String feedback;

    public InterviewResponse() {
    }

    public InterviewResponse(int interviewId, Date interviewDate, String feedback) {
        this.interviewId = interviewId;
        this.interviewDate = interviewDate;
        this.feedback = feedback;
    }

    public int getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
