package com.HRManagementInformation.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class JobOffers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offerId;
    //@OneToOne
    //private int recruitmentId;
    private Date offerDate;
    private double offeredSalary;
    private String offerStatus;
    private String feedback;

    public JobOffers(int offerId, Date offerDate, double offeredSalary, String offerStatus, String feedback) {
        this.offerId = offerId;
        this.offerDate = offerDate;
        this.offeredSalary = offeredSalary;
        this.offerStatus = offerStatus;
        this.feedback = feedback;
    }

    public JobOffers() {
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    public double getOfferedSalary() {
        return offeredSalary;
    }

    public void setOfferedSalary(double offeredSalary) {
        this.offeredSalary = offeredSalary;
    }

    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(String offerStatus) {
        this.offerStatus = offerStatus;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
