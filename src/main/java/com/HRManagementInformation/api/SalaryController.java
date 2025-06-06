package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.ISalaryService;
import com.HRManagementInformation.business.abstracts.IUserService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.salary.SalarySaveRequest;
import com.HRManagementInformation.dto.request.salary.SalaryUpdateRequest;
import com.HRManagementInformation.dto.response.SalaryResponse;
import com.HRManagementInformation.dto.response.UserResponse;
import com.HRManagementInformation.entities.Salary;
import com.HRManagementInformation.entities.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/salary")
public class SalaryController {
    private final ISalaryService salaryService;
    private final IModelMapperService modelMapperService;
    private final IUserService userService;

    @Autowired
    public SalaryController(ISalaryService salaryService, IModelMapperService modelMapperService, IUserService userService) {
        this.salaryService = salaryService;
        this.modelMapperService = modelMapperService;
        this.userService = userService;
    }

    @GetMapping("")
    public String getSalaryPage(Model model) {
        try {
            List<Salary> salaries = this.salaryService.getAll();
            List<User> users = this.userService.getAll();
            
            List<SalaryResponse> salaryResponses = salaries.stream()
                .map(salary -> this.modelMapperService.forResponse().map(salary, SalaryResponse.class))
                .collect(Collectors.toList());
                
            List<UserResponse> userResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse().map(user, UserResponse.class))
                .collect(Collectors.toList());
            
            model.addAttribute("salaries", salaryResponses);
            model.addAttribute("users", userResponses);
            return "salary";
        } catch (Exception e) {
            model.addAttribute("error", "Maaş bilgileri yüklenirken bir hata oluştu: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/edit/{id}")
    public String getEditSalaryPage(@PathVariable("id") int id, Model model) {
        try {
            Salary salary = this.salaryService.get(id);
            List<User> users = this.userService.getAll();
            
            List<UserResponse> userResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse().map(user, UserResponse.class))
                .collect(Collectors.toList());
            
            model.addAttribute("salary", salary);
            model.addAttribute("users", userResponses);
            return "salary-edit";
        } catch (Exception e) {
            model.addAttribute("error", "Maaş bilgileri yüklenirken bir hata oluştu: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/api")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<SalaryResponse>> getSalaries(){
        List<Salary> salaries = this.salaryService.getAll();
        List<SalaryResponse> salaryResponses = salaries.stream().
                map(salary -> this.modelMapperService.forResponse().map(salary, SalaryResponse.class))
                .collect(Collectors.toList());
        return ResultHelper.success(salaryResponses);
    }

    @GetMapping("/api/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SalaryResponse> getSalary(@PathVariable("id") int id){
        Salary salary = this.salaryService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(salary, SalaryResponse.class));
    }

    @PostMapping("/api")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<SalaryResponse> createSalary(@RequestBody SalarySaveRequest salarySaveRequest){
        try {
            if (salarySaveRequest == null) {
                throw new IllegalArgumentException("Salary request cannot be null");
            }
            
            if (salarySaveRequest.getUserId() <= 0) {
                throw new IllegalArgumentException("Invalid user ID");
            }
            
            User user = userService.get(salarySaveRequest.getUserId());
            if (user == null) {
                throw new EntityNotFoundException("User not found with ID: " + salarySaveRequest.getUserId());
            }
            
            Salary salary = new Salary();
            salary.setSalaryAmount(salarySaveRequest.getSalaryAmount());
            salary.setPaymentDate(salarySaveRequest.getPaymentDate());
            salary.setUser(user);
            
            Salary savedSalary = this.salaryService.save(salary);
            SalaryResponse response = this.modelMapperService.forResponse().map(savedSalary, SalaryResponse.class);
            return ResultHelper.created(response);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid request: " + e.getMessage(), e);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("User not found: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error creating salary: " + e.getMessage(), e);
        }
    }

    @PutMapping("/api/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SalaryResponse> updateSalary(@PathVariable("id") int id,
                                                 @RequestBody SalaryUpdateRequest salaryUpdateRequest) {
        try {
            Salary existingSalary = this.salaryService.get(id);
            User user = userService.get(salaryUpdateRequest.getUserId());
            if (user == null) {
                throw new EntityNotFoundException("User not found with ID: " + salaryUpdateRequest.getUserId());
            }
            
            existingSalary.setSalaryAmount(salaryUpdateRequest.getSalaryAmount());
            existingSalary.setPaymentDate(salaryUpdateRequest.getPaymentDate());
            existingSalary.setUser(user);
            
            Salary updatedSalary = this.salaryService.update(existingSalary);
            return ResultHelper.updated(this.modelMapperService.forResponse().map(updatedSalary, SalaryResponse.class));
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("User not found: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error updating salary: " + e.getMessage(), e);
        }
    }

    @DeleteMapping("/api/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteSalary(@PathVariable("id") int id){
        this.salaryService.delete(id);
        return ResultHelper.ok();
    }
}
