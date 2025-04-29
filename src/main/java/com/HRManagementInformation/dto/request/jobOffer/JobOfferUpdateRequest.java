package com.HRManagementInformation.dto.request.jobOffer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.sql.Date;

public class JobOfferUpdateRequest {
    @NotNull(message = "teklif tarihi boş olamaz")
    private Date offerDate;

    @NotNull(message = "teklif edilen maaş boş olamaz")
    @Positive(message = "teklif edilen maaş pozitif bir değer olmak zorunda")
    private double offeredSalary;

    @NotNull(message = "teklif durumu boş olamaz")
    private String offerStatus;

    private String feedback;

    public JobOfferUpdateRequest() {
    }

    public JobOfferUpdateRequest(Date offerDate, double offeredSalary, String offerStatus, String feedback) {
        this.offerDate = offerDate;
        this.offeredSalary = offeredSalary;
        this.offerStatus = offerStatus;
        this.feedback = feedback;
    }

    @NotNull(message = "teklif tarihi boş olamaz")
    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(@NotNull(message = "teklif tarihi boş olamaz") Date offerDate) {
        this.offerDate = offerDate;
    }

    @NotNull(message = "teklif edilen maaş boş olamaz")
    @Positive(message = "teklif edilen maaş pozitif bir değer olmak zorunda")
    public double getOfferedSalary() {
        return offeredSalary;
    }

    public void setOfferedSalary(@NotNull(message = "teklif edilen maaş boş olamaz")
                                @Positive(message = "teklif edilen maaş pozitif bir değer olmak zorunda") double offeredSalary) {
        this.offeredSalary = offeredSalary;
    }

    @NotNull(message = "teklif durumu boş olamaz")
    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(@NotNull(message = "teklif durumu boş olamaz") String offerStatus) {
        this.offerStatus = offerStatus;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
} 