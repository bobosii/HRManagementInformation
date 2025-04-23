package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IJobOffersService;
import com.HRManagementInformation.dao.JobOfferRepository;
import com.HRManagementInformation.entities.Interviews;
import com.HRManagementInformation.entities.JobOffers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOfferManager implements IJobOffersService {
    @Autowired
    private final JobOfferRepository jobOfferRepository;

    public JobOfferManager(JobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
    }

    @Override
    public JobOffers save(JobOffers jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    @Override
    public JobOffers get(int offerId) {
        return jobOfferRepository.findById(offerId).orElseThrow();
    }

    @Override
    public JobOffers update(JobOffers jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    @Override
    public List<JobOffers> getAll() {
        return jobOfferRepository.findAll();
    }

    @Override
    public boolean delete(int offerId) {
        JobOffers jobOffer = this.get(offerId);
        jobOfferRepository.delete(jobOffer);
        return true;
    }
}
