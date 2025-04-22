package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.JobOffers;

import java.util.List;

public interface IJobOffersService {
    JobOffers save(JobOffers jobOffer);
    JobOffers get(int offerId);
    JobOffers update(JobOffers jobOffer);
    List<JobOffers> getAll();
    boolean delete(int offerId);
}
