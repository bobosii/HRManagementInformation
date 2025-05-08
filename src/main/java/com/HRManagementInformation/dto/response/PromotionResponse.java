package com.HRManagementInformation.dto.response;

import java.sql.Date;

public class PromotionResponse {
    private int promotionId;
    private int userId;
    private String userFullName;
    private int oldRoleId;
    private String oldRoleTitle;
    private int newRoleId;
    private String newRoleTitle;
    private Date promotionDate;
    private double salaryIncreaseRate;
    private String note;

    public PromotionResponse(){}

    public PromotionResponse(int promotionId, int userId, String userFullName, int oldRoleId, String oldRoleTitle, int newRoleId, String newRoleTitle, Date promotionDate, double salaryIncreaseRate, String note) {
        this.promotionId = promotionId;
        this.userId = userId;
        this.userFullName = userFullName;
        this.oldRoleId = oldRoleId;
        this.oldRoleTitle = oldRoleTitle;
        this.newRoleId = newRoleId;
        this.newRoleTitle = newRoleTitle;
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

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public int getOldRoleId() {
        return oldRoleId;
    }

    public void setOldRoleId(int oldRoleId) {
        this.oldRoleId = oldRoleId;
    }

    public String getOldRoleTitle() {
        return oldRoleTitle;
    }

    public void setOldRoleTitle(String oldRoleTitle) {
        this.oldRoleTitle = oldRoleTitle;
    }

    public int getNewRoleId() {
        return newRoleId;
    }

    public void setNewRoleId(int newRoleId) {
        this.newRoleId = newRoleId;
    }

    public String getNewRoleTitle() {
        return newRoleTitle;
    }

    public void setNewRoleTitle(String newRoleTitle) {
        this.newRoleTitle = newRoleTitle;
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
