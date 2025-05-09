package com.HRManagementInformation.dao;

import com.HRManagementInformation.entities.InsuranceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRecordRepository extends JpaRepository<InsuranceRecord, Integer> {
}
