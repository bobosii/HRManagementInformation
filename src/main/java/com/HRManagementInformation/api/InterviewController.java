package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IInterviewsService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.InterviewSaveRequest;
import com.HRManagementInformation.dto.request.InterviewUpdateRequest;
import com.HRManagementInformation.dto.response.InterviewResponse;
import com.HRManagementInformation.entities.Interviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/interview")
public class InterviewController {
    @Autowired
    private final IInterviewsService interviewsService;
    @Autowired
    private final IModelMapperService modelMapperService;

    public InterviewController(IInterviewsService interviewsService, IModelMapperService modelMapperService) {
        this.interviewsService = interviewsService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<InterviewResponse>> getAllInterviews() {
        List<Interviews> interviews = interviewsService.getAll();

        List<InterviewResponse> interviewResponses = interviews.stream()
                .map(interview -> modelMapperService.forResponse().map(interview, InterviewResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(interviewResponses);
    }

    @GetMapping("/{interview-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<InterviewResponse> getInterviewById(@PathVariable("interview-id") int interviewId) {
        Interviews interview = this.interviewsService.get(interviewId);
        return ResultHelper.success(this.modelMapperService.forResponse().map(interview, InterviewResponse.class));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<InterviewResponse> saveInterview(@RequestBody InterviewSaveRequest interviewSaveRequest) {
        Interviews saveInterview = this.modelMapperService.forRequest().map(interviewSaveRequest, Interviews.class);
        this.interviewsService.save(saveInterview);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveInterview, InterviewResponse.class));
    }

    @PutMapping("/{interview-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<InterviewResponse> updateInterview(@PathVariable("interview-id") int interviewId,
                                                       @RequestBody InterviewUpdateRequest interviewUpdateRequest) {
        Interviews existingInterview = this.interviewsService.get(interviewId);
        this.modelMapperService.forRequest().map(interviewUpdateRequest, existingInterview);
        this.interviewsService.update(existingInterview);

        return ResultHelper.success(this.modelMapperService.forResponse().map(existingInterview, InterviewResponse.class));
    }

    @DeleteMapping("/{interview-id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteInterview(@PathVariable("interview-id") int interviewId) {
        this.interviewsService.delete(interviewId);
        return ResultHelper.ok();
    }
} 