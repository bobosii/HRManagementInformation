package com.HRManagementInformation.dao;

import com.HRManagementInformation.entities.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRecordTypeRepository extends JpaRepository<InsuranceType,Integer> {
}
