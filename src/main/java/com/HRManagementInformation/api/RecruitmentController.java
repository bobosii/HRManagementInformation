package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IRecruitmentService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.RecruitmentSaveRequest;
import com.HRManagementInformation.dto.request.RecruitmentUpdateRequest;
import com.HRManagementInformation.dto.response.RecruitmentResponse;
import com.HRManagementInformation.entities.Recruitment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/{recruitment-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<RecruitmentResponse> getRecruitmentById(@PathVariable("recruitment-id") int recruitmentId){
        Recruitment recruitment = this.recruitmentService.get(recruitmentId);

        return ResultHelper.success(this.modelMapperService.forResponse().map(recruitment, RecruitmentResponse.class));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<RecruitmentResponse> saveRecruitment(@RequestBody RecruitmentSaveRequest recruitmentSaveRequest){
        Recruitment saveRecruitment = this.modelMapperService.forRequest().map(recruitmentSaveRequest, Recruitment.class);
        this.recruitmentService.save(saveRecruitment);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveRecruitment, RecruitmentResponse.class));
    }

    @PutMapping("/{recruitment-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<RecruitmentResponse> updateRecruitment(
            @PathVariable("recruitment-id") int recruitmentId,
            @RequestBody RecruitmentUpdateRequest recruitmentUpdateRequest){
        Recruitment existingRecruitment = this.recruitmentService.get(recruitmentId);
        this.modelMapperService.forRequest().map(recruitmentUpdateRequest, existingRecruitment);
        this.recruitmentService.update(existingRecruitment);

        return ResultHelper.success(this.modelMapperService.forResponse().map(existingRecruitment, RecruitmentResponse.class));
    }

    @DeleteMapping("/{recruitment-id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteRecruitment(@PathVariable("recruitment-id") int recruitmentId){
        recruitmentService.delete(recruitmentId);
        return ResultHelper.ok();
    }

}
