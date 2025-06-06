package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.ILeaveRequestService;
import com.HRManagementInformation.business.abstracts.ILeaveTypeService;
import com.HRManagementInformation.business.abstracts.IUserService;
import com.HRManagementInformation.entities.LeaveRequest;
import com.HRManagementInformation.entities.LeaveType;
import com.HRManagementInformation.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@RequestMapping("/leave-requests")
public class LeaveRequestController {

    private final ILeaveRequestService leaveRequestService;
    private final IUserService userService;
    private final ILeaveTypeService leaveTypeService;

    public LeaveRequestController(ILeaveRequestService leaveRequestService,
                                  IUserService userService,
                                  ILeaveTypeService leaveTypeService) {
        this.leaveRequestService = leaveRequestService;
        this.userService = userService;
        this.leaveTypeService = leaveTypeService;
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("leaveTypes", leaveTypeService.getAll());
        model.addAttribute("leaveRequests", leaveRequestService.getAll());
        return "leave-requests";
    }

    @PostMapping("/submit-form")
    public String submitLeaveForm(@RequestParam("userId") int userId,
                                  @RequestParam("leaveTypeId") int leaveTypeId,
                                  @RequestParam("startDate") String startDate,
                                  @RequestParam("endDate") String endDate,
                                  @RequestParam("reason") String reason) {
        LeaveRequest request = new LeaveRequest();
        request.setUser(userService.get(userId));
        request.setLeaveType(leaveTypeService.get(leaveTypeId));
        request.setStartDate(java.time.LocalDate.parse(startDate));
        request.setEndDate(java.time.LocalDate.parse(endDate));
        request.setTotalDays(ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate()) + 1);
        request.setReason(reason);
        request.setStatus("Beklemede");
        leaveRequestService.save(request);
        return "redirect:/leave-requests/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteLeave(@PathVariable int id) {
        leaveRequestService.delete(id);
        return "redirect:/leave-requests/form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        LeaveRequest leaveRequest = leaveRequestService.get(id);
        model.addAttribute("leaveRequest", leaveRequest);
        model.addAttribute("users", userService.getAll());
        model.addAttribute("leaveTypes", leaveTypeService.getAll());
        return "leave-requests-edit"; // Bunu da vereceğim
    }

    @PostMapping("/update/{id}")
    public String updateLeave(@PathVariable int id,
                              @RequestParam("userId") int userId,
                              @RequestParam("leaveTypeId") int leaveTypeId,
                              @RequestParam("startDate") String startDate,
                              @RequestParam("endDate") String endDate,
                              @RequestParam("reason") String reason) {
        LeaveRequest request = leaveRequestService.get(id);
        request.setUser(userService.get(userId));
        request.setLeaveType(leaveTypeService.get(leaveTypeId));
        request.setStartDate(java.time.LocalDate.parse(startDate));
        request.setEndDate(java.time.LocalDate.parse(endDate));
        request.setTotalDays(ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate()) + 1);
        request.setReason(reason);
        leaveRequestService.update(request);
        return "redirect:/leave-requests/form";
    }
}
