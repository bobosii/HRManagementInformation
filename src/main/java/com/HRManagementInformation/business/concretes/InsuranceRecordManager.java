package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IInsuranceRecordService;
import com.HRManagementInformation.dao.InsuranceRecordRepository;
import com.HRManagementInformation.entities.InsuranceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceRecordManager implements IInsuranceRecordService {
    @Autowired
    private final InsuranceRecordRepository insuranceRecordRepository;

    public InsuranceRecordManager(InsuranceRecordRepository insuranceRecordRepository) {
        this.insuranceRecordRepository = insuranceRecordRepository;
    }

    @Override
    public InsuranceRecord save(InsuranceRecord insuranceRecord) {
        return this.insuranceRecordRepository.save(insuranceRecord);
    }

    @Override
    public InsuranceRecord get(int id) {
        return this.insuranceRecordRepository.findById(id).orElseThrow();
    }

    @Override
    public InsuranceRecord update(InsuranceRecord insuranceRecord) {
        InsuranceRecord updateInsurance = this.get(insuranceRecord.getInsuranceId());
        return this.insuranceRecordRepository.save(updateInsurance);
    }

    @Override
    public List<InsuranceRecord> getAll() {
        return this.insuranceRecordRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        InsuranceRecord insuranceRecord = this.get(id);
        this.insuranceRecordRepository.delete(insuranceRecord);
        return true;
    }
}
