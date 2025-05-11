package com.HRManagementInformation.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class HrMeetingNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Date meetingDate;
    private String category;

    @Column(columnDefinition = "TEXT")
    private String notes;

    public HrMeetingNote() {}

    public HrMeetingNote(int noteId, User user, Date meetingDate, String category, String notes) {
        this.noteId = noteId;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
