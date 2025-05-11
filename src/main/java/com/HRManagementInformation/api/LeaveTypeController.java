package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.ILeaveTypeService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.leaveType.LeaveTypeSaveRequest;
import com.HRManagementInformation.dto.request.leaveType.LeaveTypeUpdateRequest;
import com.HRManagementInformation.dto.response.LeaveTypeResponse;
import com.HRManagementInformation.entities.LeaveType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/leave-types")
public class LeaveTypeController {

    private final ILeaveTypeService leaveTypeService;
    private final IModelMapperService modelMapperService;

    public LeaveTypeController(ILeaveTypeService leaveTypeService, IModelMapperService modelMapperService) {
        this.leaveTypeService = leaveTypeService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<LeaveTypeResponse>> getAll() {
        List<LeaveType> leaveTypes = leaveTypeService.getAll();
        List<LeaveTypeResponse> responseList = leaveTypes.stream()
                .map(lt -> modelMapperService.forResponse().map(lt, LeaveTypeResponse.class))
                .collect(Collectors.toList());
        return ResultHelper.success(responseList);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<LeaveTypeResponse> getById(@PathVariable("id") int id) {
        LeaveType leaveType = leaveTypeService.get(id);
        return ResultHelper.success(modelMapperService.forResponse().map(leaveType, LeaveTypeResponse.class));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<LeaveTypeResponse> save(@RequestBody LeaveTypeSaveRequest request) {
        LeaveType entity = modelMapperService.forRequest().map(request, LeaveType.class);
        LeaveType saved = leaveTypeService.save(entity);
        return ResultHelper.created(modelMapperService.forResponse().map(saved, LeaveTypeResponse.class));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<LeaveTypeResponse> update(@PathVariable("id") int id, @RequestBody LeaveTypeUpdateRequest request) {
        LeaveType existing = leaveTypeService.get(id);
        modelMapperService.forRequest().map(request, existing);
        leaveTypeService.update(existing);
        return ResultHelper.updated(modelMapperService.forResponse().map(existing, LeaveTypeResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        leaveTypeService.delete(id);
        return ResultHelper.ok();
    }
}
