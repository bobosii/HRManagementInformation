package com.HRManagementInformation.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promotionId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "old_role_id")
    private Role oldRole;

    @ManyToOne
    @JoinColumn(name = "new_role_id")
    private Role newRole;

    private Date promotionDate;
    private double salaryIncreaseRate;
    private String note;

    // Constructors
    public Promotion() {
    }

    public Promotion(int promotionId, User user, Role oldRole, Role newRole, Date promotionDate, double salaryIncreaseRate, String note) {
        this.promotionId = promotionId;
        this.user = user;
        this.oldRole = oldRole;
        this.newRole = newRole;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getOldRole() {
        return oldRole;
    }

    public void setOldRole(Role oldRole) {
        this.oldRole = oldRole;
    }

    public Role getNewRole() {
        return newRole;
    }

    public void setNewRole(Role newRole) {
        this.newRole = newRole;
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
}