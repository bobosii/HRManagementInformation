package com.HRManagementInformation.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class EmployeeDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String filePath;
    private Date uploadDate;
    private Date validUntil;

    public EmployeeDocuments() {
    }

    public EmployeeDocuments(int documentId, User user, String filePath, Date uploadDate, Date validUntil) {
        this.documentId = documentId;
        this.user = user;
        this.filePath = filePath;
        this.uploadDate = uploadDate;
        this.validUntil = validUntil;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }
}