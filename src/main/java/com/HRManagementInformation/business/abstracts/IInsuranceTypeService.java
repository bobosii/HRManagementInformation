package com.HRManagementInformation.business.abstracts;


import com.HRManagementInformation.entities.InsuranceType;

import java.util.List;

public interface IInsuranceTypeService {

    InsuranceType save(InsuranceType insuranceType);
    InsuranceType get(int id);
    InsuranceType update(InsuranceType insuranceType);
    List<InsuranceType> getAll();
    boolean delete(int id);
}
