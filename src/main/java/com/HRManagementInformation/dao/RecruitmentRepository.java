package com.HRManagementInformation.dao;

import com.HRManagementInformation.entities.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Integer> {
}
