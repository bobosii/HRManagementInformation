package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.ISalaryService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.salary.SalarySaveRequest;
import com.HRManagementInformation.dto.response.SalaryResponse;
import com.HRManagementInformation.entities.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {
    @Autowired
    private final ISalaryService salaryService;
    @Autowired
    private final IModelMapperService modelMapperService;


    public SalaryController(ISalaryService salaryService, IModelMapperService modelMapperService) {
        this.salaryService = salaryService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<SalaryResponse>> getSalaries(){
        List<Salary> salaries = this.salaryService.getAll();
        List<SalaryResponse> salaryResponses = salaries.stream().
                map(salary -> this.modelMapperService.forResponse().map(salary, SalaryResponse.class))
                .collect(Collectors.toList());
        return ResultHelper.success(salaryResponses);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SalaryResponse> getSalary(@PathVariable("id") int id){
        Salary salary = this.salaryService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(salary, SalaryResponse.class));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<SalaryResponse> createSalary(@RequestBody SalarySaveRequest salarySaveRequest){
        Salary salary = this.modelMapperService.forRequest().map(salarySaveRequest,Salary.class);
        this.salaryService.save(salary);
        return ResultHelper.created(this.modelMapperService.forResponse().map(salary, SalaryResponse.class));
    }

    // todo! Update kisimi sonrasinda eklenecek

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteSalary(@PathVariable("id") int id){
        Salary deleteSalary = this.salaryService.get(id);
        this.salaryService.delete(deleteSalary.getId());
        return ResultHelper.ok();
    }
}
