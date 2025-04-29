package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.ILeaveRequestService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.LeaveRequestSaveRequest;
import com.HRManagementInformation.dto.request.LeaveRequestUpdateRequest;
import com.HRManagementInformation.dto.response.LeaveRequestResponse;
import com.HRManagementInformation.entities.LeaveRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/leave-requests")
public class LeaveRequestController {

    private final ILeaveRequestService leaveRequestService;
    private final IModelMapperService modelMapperService;

    public LeaveRequestController(ILeaveRequestService leaveRequestService, IModelMapperService modelMapperService) {
        this.leaveRequestService = leaveRequestService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<LeaveRequestResponse>> getAll() {
        List<LeaveRequest> leaveRequests = leaveRequestService.getAll();
        List<LeaveRequestResponse> responseList = leaveRequests.stream()
                .map(lr -> modelMapperService.forResponse().map(lr, LeaveRequestResponse.class))
                .collect(Collectors.toList());
        return ResultHelper.success(responseList);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<LeaveRequestResponse> getById(@PathVariable("id") int id) {
        LeaveRequest leaveRequest = leaveRequestService.get(id);
        return ResultHelper.success(modelMapperService.forResponse().map(leaveRequest, LeaveRequestResponse.class));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<LeaveRequestResponse> save(@RequestBody LeaveRequestSaveRequest request) {
        LeaveRequest entity = modelMapperService.forRequest().map(request, LeaveRequest.class);
        LeaveRequest saved = leaveRequestService.save(entity);
        return ResultHelper.created(modelMapperService.forResponse().map(saved, LeaveRequestResponse.class));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<LeaveRequestResponse> update(@PathVariable("id") int id, @RequestBody LeaveRequestUpdateRequest request) {
        LeaveRequest existing = leaveRequestService.get(id);
        modelMapperService.forRequest().map(request, existing);
        leaveRequestService.update(existing);
        return ResultHelper.success(modelMapperService.forResponse().map(existing, LeaveRequestResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        leaveRequestService.delete(id);
        return ResultHelper.ok();
    }
}
