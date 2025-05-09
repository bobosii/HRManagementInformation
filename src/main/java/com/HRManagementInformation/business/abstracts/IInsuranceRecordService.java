package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.InsuranceRecord;
import java.util.List;

public interface IInsuranceRecordService {

    InsuranceRecord save(InsuranceRecord insuranceRecord);
    InsuranceRecord get(int id);
    InsuranceRecord update(InsuranceRecord insuranceRecord);
    List<InsuranceRecord> getAll();
    boolean delete(int id);
}
