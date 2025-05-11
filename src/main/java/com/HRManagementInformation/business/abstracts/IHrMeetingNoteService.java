package com.HRManagementInformation.business.abstracts;
import com.HRManagementInformation.entities.HrMeetingNote;
import java.util.List;

public interface IHrMeetingNoteService {

    HrMeetingNote save(HrMeetingNote hrMeetingNote);
    HrMeetingNote get(int id);
    HrMeetingNote update(HrMeetingNote hrMeetingNote);
    List<HrMeetingNote> getAll();
    boolean delete(int id);
}
