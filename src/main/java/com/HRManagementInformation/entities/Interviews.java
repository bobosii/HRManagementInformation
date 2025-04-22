package com.HRManagementInformation.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class Interviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interviewId;
    //@OneToOne
    //private int userId;
    private Date interviewDate;
    private String feedback;

    public Interviews(int interviewId, Date interviewDate, String feedback) {
        this.interviewId = interviewId;
        this.interviewDate = interviewDate;
        this.feedback = feedback;
    }

    public Interviews() {
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
