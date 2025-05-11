package com.HRManagementInformation.dto.response;

import java.sql.Date;

public class HrMeetingNoteResponse {

    private int noteId;
    private int userId;
    private Date meetingDate;
    private String category;
    private String notes;

    public HrMeetingNoteResponse() {}

    public HrMeetingNoteResponse(int noteId, int userId, Date meetingDate, String category, String notes) {
        this.noteId = noteId;
        this.userId = userId;
        this.meetingDate = meetingDate;
        this.category = category;
        this.notes = notes;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
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

