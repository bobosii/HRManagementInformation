package com.HRManagementInformation.dto.request.hrMeetingNote;

import java.sql.Date;

public class HrMeetingNoteSaveRequest {

    private int userId;
    private Date meetingDate;
    private String category;
    private String notes;

    public HrMeetingNoteSaveRequest() {}

    public HrMeetingNoteSaveRequest(int userId, Date meetingDate, String category, String notes) {
        this.userId = userId;
        this.meetingDate = meetingDate;
        this.category = category;
        this.notes = notes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
