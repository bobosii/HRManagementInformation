package com.HRManagementInformation.dao;

import com.HRManagementInformation.entities.PayrollRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRecordsRepository extends JpaRepository<PayrollRecord, Integer> {
}
