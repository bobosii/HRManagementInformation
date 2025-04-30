package com.HRManagementInformation.dao;

import com.HRManagementInformation.entities.ExitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExitRecordRepository extends JpaRepository<ExitRecord,Integer> {
}
