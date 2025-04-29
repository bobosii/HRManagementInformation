package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IDepartmentsService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.DepartmentSaveRequest;
import com.HRManagementInformation.dto.request.DepartmentUpdateRequest;
import com.HRManagementInformation.dto.response.DepartmentResponse;
import com.HRManagementInformation.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private final IDepartmentsService departmentsService;
    @Autowired
    private final IModelMapperService modelMapper;

    public DepartmentController(IDepartmentsService departmentsService, IModelMapperService modelMapper) {
        this.departmentsService = departmentsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DepartmentResponse> getDepartment(@PathVariable("id") int id){
        Department department = this.departmentsService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(department,DepartmentResponse.class));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<DepartmentResponse>> getAllDepartments(){
        List<Department> departmentList = departmentsService.getAll();
        List<DepartmentResponse> departmentResponseList = departmentList.stream()
                .map(departments -> this.modelMapper.forResponse().map(departments, DepartmentResponse.class)).collect(Collectors.toList());
        return ResultHelper.success(departmentResponseList);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<DepartmentResponse> createDepartment(@RequestBody DepartmentSaveRequest departmentSaveRequest){
        Department createDepartment = this.modelMapper.forRequest().map(departmentSaveRequest,Department.class);
        this.departmentsService.save(createDepartment);
        return ResultHelper.created(this.modelMapper.forResponse().map(createDepartment, DepartmentResponse.class));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DepartmentResponse> updateDepartment(@RequestBody DepartmentUpdateRequest departmentUpdateRequest){
        Department department = departmentsService.get(departmentUpdateRequest.getId());

        department.setName(departmentUpdateRequest.getName());
        department.setDescription(departmentUpdateRequest.getDescription());

        Department updatedDepartment = departmentsService.save(department);

        DepartmentResponse response = new DepartmentResponse(
                updatedDepartment.getName(),
                updatedDepartment.getDescription()
        );

        return ResultHelper.updated(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteDepartment(@PathVariable("id") int id){
        this.departmentsService.delete(id);
        return ResultHelper.deleted();
    }

}
