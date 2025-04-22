package com.HRManagementInformation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.sql.Date;

public class RecruitmentSaveRequest {
    @Positive(message = "id pozitif bir değer olmak zorunda")
    @NotNull(message = "id değeri null veya boş olamaz")
    private int recruitmentId;

    @NotBlank(message = "isim alanı boş olamaz")
    private String candidateName;

    @NotNull(message = "başvuru tarihi boş olamaz")
    @Past(message = "başvuru tarihi geçmiş bir tarih olmalıdır")
    private Date applicationDate;

    @NotNull(message = "durum boş olamaz")
    private String status;
    private String notes;

    //@ManyToOne
    //private int roleId ToDo


    public RecruitmentSaveRequest(int recruitmentId, String candidateName, Date applicationDate, String status, String notes) {
        this.recruitmentId = recruitmentId;
        this.candidateName = candidateName;
        this.applicationDate = applicationDate;
        this.status = status;
        this.notes = notes;
    }

    @Positive(message = "id pozitif bir deger olmak zorunda")
    @NotNull(message = "id degeri null veya bos olamaz")
    public int getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(@Positive(message = "id pozitif bir deger olmak zorunda") @NotNull(message = "id degeri null veya bos olamaz") int recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public @NotBlank(message = "İsim alanı boş olamaz.") String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(@NotBlank(message = "İsim alanı boş olamaz.") String candidateName) {
        this.candidateName = candidateName;
    }

    public @NotNull(message = "Başvuru tarihi boş olamaz !") @Past(message = "Başvuru tarihi geçmiş bir tarihte olmalıdır !") Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(@NotNull(message = "Başvuru tarihi boş olamaz !") @Past(message = "Başvuru tarihi geçmiş bir tarihte olmalıdır !") Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public @NotBlank(message = "Durum boş olamaz") String getStatus(){
        return status;
    }

    public void setStatus(@NotBlank(message = "Durum boş olamaz ! ") String status){
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
