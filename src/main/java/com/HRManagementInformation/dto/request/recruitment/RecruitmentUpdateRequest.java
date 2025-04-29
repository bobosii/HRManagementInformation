package com.HRManagementInformation.dto.request.recruitment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.sql.Date;

public class RecruitmentUpdateRequest {
    @NotBlank(message = "İsim alanı boş olamaz")
    private String candidateName;

    @Past(message = "Başvuru tarihi geçmiş bir tarih olmalıdır")
    private Date applicationDate;

    @NotBlank(message = "Durum boş olamaz")
    private String status;

    private String notes;

    public RecruitmentUpdateRequest() {
    }

    public RecruitmentUpdateRequest(String candidateName, Date applicationDate, String status, String notes) {
        this.candidateName = candidateName;
        this.applicationDate = applicationDate;
        this.status = status;
        this.notes = notes;
    }

    public @NotBlank(message = "İsim alanı boş olamaz.") String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(@NotBlank(message = "İsim alanı boş olamaz.") String candidateName) {
        this.candidateName = candidateName;
    }

    public @Past(message = "Başvuru tarihi geçmiş bir tarih olmalıdır.") Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(@Past(message = "Başvuru tarihi geçmiş bir tarih olmalıdır.") Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public @NotBlank(message = "Durum boş olamaz.") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Durum boş olamaz.") String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
