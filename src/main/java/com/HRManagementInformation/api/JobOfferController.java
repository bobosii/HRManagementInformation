package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IJobOffersService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.jobOffer.JobOfferSaveRequest;
import com.HRManagementInformation.dto.request.jobOffer.JobOfferUpdateRequest;
import com.HRManagementInformation.dto.response.JobOfferResponse;
import com.HRManagementInformation.entities.JobOffers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/job-offer")
public class JobOfferController {
    @Autowired
    private final IJobOffersService jobOffersService;
    @Autowired
    private final IModelMapperService modelMapperService;

    public JobOfferController(IJobOffersService jobOffersService, IModelMapperService modelMapperService) {
        this.jobOffersService = jobOffersService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<JobOfferResponse>> getAllJobOffers() {
        List<JobOffers> jobOffers = jobOffersService.getAll();

        List<JobOfferResponse> jobOfferResponses = jobOffers.stream()
                .map(jobOffer -> modelMapperService.forResponse().map(jobOffer, JobOfferResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(jobOfferResponses);
    }

    @GetMapping("/{offer-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<JobOfferResponse> getJobOfferById(@PathVariable("offer-id") int offerId) {
        JobOffers jobOffer = this.jobOffersService.get(offerId);
        return ResultHelper.success(this.modelMapperService.forResponse().map(jobOffer, JobOfferResponse.class));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<JobOfferResponse> saveJobOffer(@RequestBody JobOfferSaveRequest jobOfferSaveRequest) {
        JobOffers saveJobOffer = this.modelMapperService.forRequest().map(jobOfferSaveRequest, JobOffers.class);
        this.jobOffersService.save(saveJobOffer);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveJobOffer, JobOfferResponse.class));
    }

    @PutMapping("/{offer-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<JobOfferResponse> updateJobOffer(@PathVariable("offer-id") int offerId,
                                                     @RequestBody JobOfferUpdateRequest jobOfferUpdateRequest) {
        JobOffers existingJobOffer = this.jobOffersService.get(offerId);
        this.modelMapperService.forRequest().map(jobOfferUpdateRequest, existingJobOffer);
        this.jobOffersService.update(existingJobOffer);

        return ResultHelper.success(this.modelMapperService.forResponse().map(existingJobOffer, JobOfferResponse.class));
    }

    @DeleteMapping("/{offer-id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteJobOffer(@PathVariable("offer-id") int offerId) {
        this.jobOffersService.delete(offerId);
        return ResultHelper.ok();
    }
} 