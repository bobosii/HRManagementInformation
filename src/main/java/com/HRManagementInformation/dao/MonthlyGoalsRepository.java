package com.HRManagementInformation.dao;

import com.HRManagementInformation.entities.MonthlyGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyGoalsRepository extends JpaRepository<MonthlyGoals, Integer> {
}