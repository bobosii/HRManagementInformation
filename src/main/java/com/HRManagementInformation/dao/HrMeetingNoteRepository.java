package com.HRManagementInformation.dao;

import com.HRManagementInformation.entities.HrMeetingNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HrMeetingNoteRepository extends JpaRepository<HrMeetingNote, Integer> {
}
