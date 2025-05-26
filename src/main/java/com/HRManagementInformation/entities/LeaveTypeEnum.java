package com.HRManagementInformation.entities;

public enum LeaveTypeEnum {
    ANNUAL("Yıllık İzin"),
    SICK("Hastalık İzni"),
    UNPAID("Ücretsiz İzin"),
    MATERNITY("Doğum İzni"),
    PATERNITY("Babalık İzni"),
    MARRIAGE("Evlilik İzni"),
    BEREAVEMENT("Ölüm İzni"),
    COMPASSIONATE("Mazeret İzni"),
    PUBLIC("Resmi Tatil"),
    OTHER("Diğer");

    private final String displayName;

    LeaveTypeEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
} 