package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IEmployeeAttendanceService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.employee.EmployeeAttendanceSaveRequest;
import com.HRManagementInformation.dto.request.employee.EmployeeAttendanceUpdateRequest;
import com.HRManagementInformation.dto.response.EmployeeAttendanceResponse;
import com.HRManagementInformation.entities.EmployeeAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/attendance")
public class EmployeeAttendanceController {
    @Autowired
    private final IEmployeeAttendanceService employeeAttendanceService;
    @Autowired
    private final IModelMapperService modelMapperService;

    public EmployeeAttendanceController(IEmployeeAttendanceService employeeAttendanceService, IModelMapperService modelMapperService) {
        this.employeeAttendanceService = employeeAttendanceService;
        this.modelMapperService = modelMapperService;
    }

    // Get all attendances
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<EmployeeAttendanceResponse>> getAllAttendances() {
        List<EmployeeAttendance> allAttendances = employeeAttendanceService.getAll();

        List<EmployeeAttendanceResponse> attendanceResponses = allAttendances.stream()
                .map(attendance -> modelMapperService.forResponse().map(attendance, EmployeeAttendanceResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(attendanceResponses);
    }

    // Get attendance by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<EmployeeAttendanceResponse> getAttendanceById(@PathVariable("id") int id) {
        EmployeeAttendance attendance = this.employeeAttendanceService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(attendance, EmployeeAttendanceResponse.class));
    }

    // Save attendance
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<EmployeeAttendanceResponse> saveAttendance(@RequestBody EmployeeAttendanceSaveRequest attendanceSaveRequest) {
        EmployeeAttendance saveAttendance = this.modelMapperService.forRequest().map(attendanceSaveRequest, EmployeeAttendance.class);
        this.employeeAttendanceService.save(saveAttendance);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveAttendance, EmployeeAttendanceResponse.class));
    }

    // Update attendance
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<EmployeeAttendanceResponse> updateAttendance(
            @PathVariable("id") int id,
            @RequestBody EmployeeAttendanceUpdateRequest attendanceUpdateRequest) {
        EmployeeAttendance existingAttendance = this.employeeAttendanceService.get(id);
        this.modelMapperService.forRequest().map(attendanceUpdateRequest, existingAttendance);
        this.employeeAttendanceService.update(existingAttendance);

        return ResultHelper.success(this.modelMapperService.forResponse().map(existingAttendance, EmployeeAttendanceResponse.class));
    }

    // Delete attendance
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteAttendance(@PathVariable("id") int id) {
        employeeAttendanceService.delete(id);
        return ResultHelper.ok();
    }
}
//..