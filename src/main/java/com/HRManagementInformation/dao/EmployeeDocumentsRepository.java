package com.HRManagementInformation.dao;

import com.HRManagementInformation.entities.EmployeeDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDocumentsRepository extends JpaRepository<EmployeeDocuments, Integer> {
}