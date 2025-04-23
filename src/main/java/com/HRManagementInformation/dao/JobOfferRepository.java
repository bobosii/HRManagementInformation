package com.HRManagementInformation.dao;

import com.HRManagementInformation.entities.JobOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffers, Integer> {
}
