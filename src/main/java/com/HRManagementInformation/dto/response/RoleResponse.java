package com.HRManagementInformation.dto.response;

public class RoleResponse {
    private int id;
    private String title;

    public RoleResponse() {}

    public RoleResponse(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
