package com.HRManagementInformation.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Recruitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recruitmentId;
    private String candidateName;
    private Date applicationDate;
    //@ManyToOne
    //private int roleId;
    private String status;
    private String notes;

    public Recruitment(int recruitmentId, String candidateName, Date applicationDate, String status, String notes) {
        this.recruitmentId = recruitmentId;
        this.candidateName = candidateName;
        this.applicationDate = applicationDate;
        this.status = status;
        this.notes = notes;
    }

    public Recruitment() {

    }

    public int getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(int recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
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
