package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IMonthlyGoalsService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.MonthlyGoalsSaveRequest;
import com.HRManagementInformation.dto.request.MonthlyGoalsUpdateRequest;
import com.HRManagementInformation.dto.response.MonthlyGoalsResponse;
import com.HRManagementInformation.entities.MonthlyGoals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/goals")
public class MonthlyGoalsController {
    @Autowired
    private final IMonthlyGoalsService monthlyGoalsService;
    @Autowired
    private final IModelMapperService modelMapperService;

    public MonthlyGoalsController(IMonthlyGoalsService monthlyGoalsService, IModelMapperService modelMapperService) {
        this.monthlyGoalsService = monthlyGoalsService;
        this.modelMapperService = modelMapperService;
    }

    // Get all goals
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<MonthlyGoalsResponse>> getAllGoals() {
        List<MonthlyGoals> allGoals = monthlyGoalsService.getAll();

        List<MonthlyGoalsResponse> goalResponses = allGoals.stream()
                .map(goal -> modelMapperService.forResponse().map(goal, MonthlyGoalsResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(goalResponses);
    }

    // Get goal by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<MonthlyGoalsResponse> getGoalById(@PathVariable("id") int id) {
        MonthlyGoals goal = this.monthlyGoalsService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(goal, MonthlyGoalsResponse.class));
    }

    // Save goal
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<MonthlyGoalsResponse> saveGoal(@RequestBody MonthlyGoalsSaveRequest goalSaveRequest) {
        MonthlyGoals saveGoal = this.modelMapperService.forRequest().map(goalSaveRequest, MonthlyGoals.class);
        this.monthlyGoalsService.save(saveGoal);
        return ResultHelper.success(this.modelMapperService.forResponse().map(saveGoal, MonthlyGoalsResponse.class));
    }

    // Update goal
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<MonthlyGoalsResponse> updateGoal(@RequestBody MonthlyGoalsUpdateRequest goalUpdateRequest) {
        MonthlyGoals updateGoal = this.modelMapperService.forRequest().map(goalUpdateRequest, MonthlyGoals.class);
        this.monthlyGoalsService.update(updateGoal);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updateGoal, MonthlyGoalsResponse.class));
    }

    // Delete goal
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteGoal(@PathVariable("id") int id) {
        monthlyGoalsService.delete(id);
        return ResultHelper.ok();
    }
}