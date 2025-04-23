package com.HRManagementInformation.dao;

import com.HRManagementInformation.business.abstracts.IInterviewsService;
import com.HRManagementInformation.entities.Interviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interviews, Integer> {

}
