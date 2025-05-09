package com.HRManagementInformation.dao;

import com.HRManagementInformation.entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {
}
