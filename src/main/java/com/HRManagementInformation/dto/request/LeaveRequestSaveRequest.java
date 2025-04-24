package com.HRManagementInformation.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class LeaveRequestSaveRequest {

    @NotNull(message = "Kullanıcı ID boş olamaz.")
    private int userId;

    @NotNull(message = "İzin tipi ID boş olamaz.")
    private int leaveTypeId;

    @NotNull(message = "Başlangıç tarihi boş olamaz.")
    @FutureOrPresent(message = "Başlangıç tarihi bugünden önce olamaz.")
    private LocalDate startDate;

    @NotNull(message = "Bitiş tarihi boş olamaz.")
    private LocalDate endDate;

    @Min(value = 0, message = "Toplam gün 0'dan küçük olamaz.")
    private double totalDays;

    private String status;

    public LeaveRequestSaveRequest() {}

    public LeaveRequestSaveRequest(int userId, int leaveTypeId, LocalDate startDate, LocalDate endDate, double totalDays, String status) {
        this.userId = userId;
        this.leaveTypeId = leaveTypeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDays = totalDays;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(int leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(double totalDays) {
        this.totalDays = totalDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
