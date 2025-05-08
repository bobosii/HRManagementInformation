package com.HRManagementInformation.dto.request.promotion;

import java.sql.Date;

public class PromotionUpdateRequest {

    private int promotionId;
    private int userId;
    private int oldRoleId;
    private int newRoleId;
    private Date promotionDate;
    private double salaryIncreaseRate;
    private String note;

    public PromotionUpdateRequest() {}

    public PromotionUpdateRequest(int promotionId, int userId, int oldRoleId, int newRoleId,
                                  Date promotionDate, double salaryIncreaseRate, String note) {
        this.promotionId = promotionId;
        this.userId = userId;
        this.oldRoleId = oldRoleId;
        this.newRoleId = newRoleId;
        this.promotionDate = promotionDate;
        this.salaryIncreaseRate = salaryIncreaseRate;
        this.note = note;
    }


    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOldRoleId() {
        return oldRoleId;
    }

    public void setOldRoleId(int oldRoleId) {
        this.oldRoleId = oldRoleId;
    }

    public int getNewRoleId() {
        return newRoleId;
    }

    public void setNewRoleId(int newRoleId) {
        this.newRoleId = newRoleId;
    }

    public Date getPromotionDate() {
        return promotionDate;
    }

    public void setPromotionDate(Date promotionDate) {
        this.promotionDate = promotionDate;
    }

    public double getSalaryIncreaseRate() {
        return salaryIncreaseRate;
    }

    public void setSalaryIncreaseRate(double salaryIncreaseRate) {
        this.salaryIncreaseRate = salaryIncreaseRate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
