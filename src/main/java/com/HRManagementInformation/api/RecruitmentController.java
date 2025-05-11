package com.HRManagementInformation.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.HRManagementInformation.business.abstracts.IRecruitmentService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.recruitment.RecruitmentSaveRequest;
import com.HRManagementInformation.dto.request.recruitment.RecruitmentUpdateRequest;
import com.HRManagementInformation.dto.response.RecruitmentResponse;
import com.HRManagementInformation.entities.Recruitment;

@RestController
@RequestMapping("/api/recruitment")
public class RecruitmentController {
    @Autowired
    private final IRecruitmentService recruitmentService;
    @Autowired
    private final IModelMapperService modelMapperService;

    public RecruitmentController(IRecruitmentService recruitmentService, IModelMapperService modelMapperService) {
        this.recruitmentService = recruitmentService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<RecruitmentResponse>> getAllRecruitments(){
        List<Recruitment> allRecruitments = recruitmentService.getAll();

        List<RecruitmentResponse> recruitmentResponses = allRecruitments.stream()
                .map(recruitment -> modelMapperService.forResponse().map(recruitment, RecruitmentResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(recruitmentResponses);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<RecruitmentResponse> getRecruitmentById(@PathVariable("id") int id){
        Recruitment recruitment = this.recruitmentService.get(id);

        return ResultHelper.success(this.modelMapperService.forResponse().map(recruitment, RecruitmentResponse.class));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<RecruitmentResponse> saveRecruitment(@RequestBody RecruitmentSaveRequest recruitmentSaveRequest){
        Recruitment saveRecruitment = this.modelMapperService.forRequest().map(recruitmentSaveRequest, Recruitment.class);
        this.recruitmentService.save(saveRecruitment);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveRecruitment, RecruitmentResponse.class));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<RecruitmentResponse> updateRecruitment(
            @PathVariable("id") int id,
            @RequestBody RecruitmentUpdateRequest recruitmentUpdateRequest){
        Recruitment existingRecruitment = this.recruitmentService.get(id);
        this.modelMapperService.forRequest().map(recruitmentUpdateRequest, existingRecruitment);
        this.recruitmentService.update(existingRecruitment);

        return ResultHelper.updated(this.modelMapperService.forResponse().map(existingRecruitment, RecruitmentResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteRecruitment(@PathVariable("id") int id){
        recruitmentService.delete(id);
        return ResultHelper.ok();
    }

}
