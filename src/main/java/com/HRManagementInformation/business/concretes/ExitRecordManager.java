package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IExitRecordService;
import com.HRManagementInformation.dao.ExitRecordRepository;
import com.HRManagementInformation.entities.ExitRecord;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExitRecordManager implements IExitRecordService {
    @Autowired
    private final ExitRecordRepository exitRecordRepository;

    public ExitRecordManager(ExitRecordRepository exitRecordRepository) {
        this.exitRecordRepository = exitRecordRepository;
    }


    @Override
    public ExitRecord save(ExitRecord exitRecord) {
        return this.exitRecordRepository.save(exitRecord);
    }

    @Override
    public ExitRecord get(int id) {
        return this.exitRecordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with ID: " + id));
    }

    @Override
    public ExitRecord update(ExitRecord exitRecord) {
        ExitRecord updateRecord = this.get(exitRecord.getId());
        return this.exitRecordRepository.save(updateRecord);
    }

    @Override
    public List<ExitRecord> getAll() {
        return this.exitRecordRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        this.exitRecordRepository.delete(this.get(id));
        return true;
    }
}
