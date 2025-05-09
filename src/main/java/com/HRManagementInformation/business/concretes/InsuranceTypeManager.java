package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IInsuranceTypeService;
import com.HRManagementInformation.dao.InsuranceRecordTypeRepository;
import com.HRManagementInformation.entities.InsuranceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceTypeManager implements IInsuranceTypeService {
    @Autowired
    private final InsuranceRecordTypeRepository typeRepository;

    public InsuranceTypeManager(InsuranceRecordTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }


    @Override
    public InsuranceType save(InsuranceType insuranceType) {
        return this.typeRepository.save(insuranceType);
    }

    @Override
    public InsuranceType get(int id) {
        return this.typeRepository.findById(id).orElseThrow();
    }

    @Override
    public InsuranceType update(InsuranceType insuranceType) {
        InsuranceType updateType = this.get(insuranceType.getInsuranceTypeId());
        return this.typeRepository.save(updateType);
    }

    @Override
    public List<InsuranceType> getAll() {
        return this.typeRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        InsuranceType removeType = this.get(id);
        this.typeRepository.delete(removeType);
        return true;
    }
}
