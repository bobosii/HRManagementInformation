package com.HRManagementInformation.business.concretes;
import com.HRManagementInformation.business.abstracts.IHrMeetingNoteService;
import com.HRManagementInformation.dao.HrMeetingNoteRepository;
import com.HRManagementInformation.entities.HrMeetingNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HrMeetingNoteManager implements IHrMeetingNoteService {
    @Autowired
    private final HrMeetingNoteRepository hrMeetingNoteRepository;

    public HrMeetingNoteManager(HrMeetingNoteRepository hrMeetingNoteRepository) {
        this.hrMeetingNoteRepository = hrMeetingNoteRepository;
    }

    @Override
    public HrMeetingNote save(HrMeetingNote hrMeetingNote) {
        return this.hrMeetingNoteRepository.save(hrMeetingNote);
    }

    @Override
    public HrMeetingNote get(int id) {
        return this.hrMeetingNoteRepository.findById(id).orElseThrow();
    }

    @Override
    public HrMeetingNote update(HrMeetingNote hrMeetingNote) {
        HrMeetingNote updateHrNote = this.get(hrMeetingNote.getNoteId());
        return this.hrMeetingNoteRepository.save(updateHrNote);
    }

    @Override
    public List<HrMeetingNote> getAll() {
        return this.hrMeetingNoteRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        HrMeetingNote hrMeetingNote = this.get(id);
        this.hrMeetingNoteRepository.delete(hrMeetingNote);
        return true;
    }
}
