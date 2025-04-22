package com.HRManagementInformation.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.sql.Date;

public class JobOfferSaveRequest {
    @Positive(message = "id pozitif bir değer olmak zorunda")
    @NotNull(message = "id değeri null veya boş olamaz")
    private int offerId;

    @NotNull(message = "recruitment id değeri null veya boş olamaz")
    private int recruitmentId;

    @NotNull(message = "teklif tarihi boş olamaz")
    private Date offerDate;

    @NotNull(message = "teklif edilen maaş boş olamaz")
    @Positive(message = "teklif edilen maaş pozitif bir değer olmak zorunda")
    private double offeredSalary;

    @NotNull(message = "teklif durumu boş olamaz")
    private String offerStatus;

    private String feedback;

    public JobOfferSaveRequest() {
    }

    public JobOfferSaveRequest(int offerId, int recruitmentId, Date offerDate, double offeredSalary, String offerStatus, String feedback) {
        this.offerId = offerId;
        this.recruitmentId = recruitmentId;
        this.offerDate = offerDate;
        this.offeredSalary = offeredSalary;
        this.offerStatus = offerStatus;
        this.feedback = feedback;
    }

    @Positive(message = "id pozitif bir değer olmak zorunda")
    @NotNull(message = "id değeri null veya boş olamaz")
    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(@Positive(message = "id pozitif bir değer olmak zorunda")
                          @NotNull(message = "id değeri null veya boş olamaz") int offerId) {
        this.offerId = offerId;
    }

    @NotNull(message = "recruitment id değeri null veya boş olamaz")
    public int getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(@NotNull(message = "recruitment id değeri null veya boş olamaz") int recruitmentId) {
        this.recruitmentId = recruitmentId;
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