package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IUserService;
import com.HRManagementInformation.business.abstracts.ILeaveTypeService;
import com.HRManagementInformation.business.abstracts.ILeaveRequestService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.dto.response.LeaveRequestResponse;
import com.HRManagementInformation.entities.LeaveTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LeaveRequestPageController {

    private final IUserService userService;
    private final ILeaveTypeService leaveTypeService;
    private final ILeaveRequestService leaveRequestService;
    private final IModelMapperService modelMapperService;

    public LeaveRequestPageController(
        IUserService userService,
        ILeaveTypeService leaveTypeService,
        ILeaveRequestService leaveRequestService,
        IModelMapperService modelMapperService
    ) {
        this.userService = userService;
        this.leaveTypeService = leaveTypeService;
        this.leaveRequestService = leaveRequestService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping("/leave-requests")
    public String leaveRequestsPage(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("leaveTypes", LeaveTypeEnum.values());
        var leaveRequests = leaveRequestService.getAll()
            .stream()
            .map(lr -> modelMapperService.forResponse().map(lr, LeaveRequestResponse.class))
            .toList();
        model.addAttribute("leaveRequests", leaveRequests);
        model.addAttribute("leaveRequestIds", leaveRequests.stream().map(lr -> lr.getId()).toList());
        return "leave-requests";
    }

    @GetMapping("/leave-requests/edit/{id}")
    public String editLeaveRequestPage(@PathVariable int id, Model model) {
        var leaveRequest = leaveRequestService.get(id);
        model.addAttribute("leaveRequest", modelMapperService.forResponse().map(leaveRequest, LeaveRequestResponse.class));
        model.addAttribute("users", userService.getAll());
        model.addAttribute("leaveTypes", LeaveTypeEnum.values());
        return "leave-requests-edit";
    }
} 