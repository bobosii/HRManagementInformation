package com.HRManagementInformation.dao;

import com.HRManagementInformation.entities.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
}
