package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.*;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.dto.response.*;
import com.HRManagementInformation.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainPageController {

    private final IUserService userService;
    private final IModelMapperService modelMapperService;
    private final IDepartmentsService departmentsService;
    private final IRoleService roleService;
    private final ILeaveTypeService leaveTypeService;
    private final IInterviewsService interviewsService;

    @Autowired
    public MainPageController(IUserService userService,
                              IModelMapperService modelMapperService,
                              IDepartmentsService departmentsService,
                              IRoleService roleService,
                              ILeaveTypeService leaveTypeService,
                              IPayrollRecordsService payrollRecordsService,
                              IInterviewsService interviewsService) {
        this.userService = userService;
        this.modelMapperService = modelMapperService;
        this.departmentsService = departmentsService;
        this.roleService = roleService;
        this.leaveTypeService = leaveTypeService;
        this.interviewsService = interviewsService;
    }

    @GetMapping({"/", "/main"})
    public String mainPage() {
        return "main";
    }

@GetMapping("/users")
public String usersPage(Model model) {
    List<UserResponse> users = userService.getAll().stream()
        .map(user -> {
            UserResponse response = new UserResponse();
            response.setId(user.getId());
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setEmail(user.getEmail());
            response.setPhone(user.getPhone());
            response.setTcNo(user.getTcNo());

            // 🟨 Null kontrolüyle birlikte rol ve departmanı elle set ediyoruz
            response.setRoleName(user.getRole() != null ? user.getRole().getTitle() : "Yok");
            response.setDepartmentName(user.getDepartment() != null ? user.getDepartment().getName() : "Yok");

            response.setHireDate(user.getHireDate());
            response.setBirthDate(user.getBirthDate());
            return response;
        })
        .collect(Collectors.toList());

    model.addAttribute("users", users);
    model.addAttribute("departments", departmentsService.getAll());
    model.addAttribute("roles", roleService.getAll());
    return "users";
}


    @GetMapping("/departments")
    public String departmentsPage(Model model) {
        List<DepartmentResponse> departments = departmentsService.getAll().stream()
                .map(dept -> modelMapperService.forResponse().map(dept, DepartmentResponse.class))
                .collect(Collectors.toList());

        model.addAttribute("departments", departments);
        model.addAttribute("newDepartment", new Department());
        return "departments";
    }

    @GetMapping("/departments/edit/{id}")
    public String editDepartmentPage(@PathVariable int id, Model model) {
        Department department = departmentsService.get(id);
        model.addAttribute("department", department);
        return "department-edit";
    }

    @GetMapping("/roles")
    public String rolesPage(Model model) {
        List<RoleResponse> roles = roleService.getAll().stream()
                .map(role -> modelMapperService.forResponse().map(role, RoleResponse.class))
                .collect(Collectors.toList());

        model.addAttribute("roles", roles);
        model.addAttribute("newRole", new Role());
        return "roles";
    }

    @GetMapping("/roles/edit/{id}")
    public String editRolePage(@PathVariable int id, Model model) {
        Role role = roleService.get(id);
        model.addAttribute("role", role);
        return "role-edit";
    }

    @GetMapping("/leave-requests")
    public String leaveRequestsPage(Model model) {
        model.addAttribute("leaveRequest", new LeaveRequest());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("leaveTypes", leaveTypeService.getAll());
        return "leave-requests";
    }

    // ------------------- MÜLAKATLAR -------------------

    @GetMapping("/interview")
    public String interviewPage(Model model) {
        model.addAttribute("interviews", interviewsService.getAll());
        model.addAttribute("users", userService.getAll());
        return "interviews";
    }

    @PostMapping("/interview/save")
    public String saveInterview(@RequestParam("userId") int userId,
                                @RequestParam("interviewDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate interviewDate,
                                @RequestParam("feedback") String feedback,
                                RedirectAttributes redirectAttributes) {

        User user = userService.getById(userId);

        Interviews interview = new Interviews();
        interview.setUser(user);
        interview.setInterviewDate(Date.valueOf(interviewDate));
        interview.setFeedback(feedback);

        interviewsService.save(interview);
        redirectAttributes.addFlashAttribute("message", "Mülakat başarıyla eklendi.");
        return "redirect:/interview";
    }

    @PostMapping("/interview/delete/{id}")
    public String deleteInterview(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        interviewsService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Mülakat silindi.");
        return "redirect:/interview";
    }

    @GetMapping("/interview/edit/{id}")
    public String editInterviewPage(@PathVariable int id, Model model) {
        Interviews interview = interviewsService.get(id);
        model.addAttribute("interview", interview);
        model.addAttribute("users", userService.getAll());
        return "interview-edit";
    }

    @PostMapping("/interview/update/{id}")
    public String updateInterview(@PathVariable int id,
                                  @RequestParam("userId") int userId,
                                  @RequestParam("interviewDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate interviewDate,
                                  @RequestParam("feedback") String feedback,
                                  RedirectAttributes redirectAttributes) {

        Interviews interview = interviewsService.get(id);
        User user = userService.getById(userId);
        interview.setUser(user);
        interview.setInterviewDate(Date.valueOf(interviewDate));
        interview.setFeedback(feedback);

        interviewsService.update(interview);
        redirectAttributes.addFlashAttribute("message", "Mülakat güncellendi.");
        return "redirect:/interview";
    }
}
