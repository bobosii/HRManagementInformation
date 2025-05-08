package com.HRManagementInformation.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class JobOffers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offerId;

    @OneToOne
    @JoinColumn(name = "recruitment_id")
    private Recruitment recruitment;

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
