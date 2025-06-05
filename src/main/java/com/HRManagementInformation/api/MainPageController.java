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

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainPageController {

    private final IUserService userService;
    private final IModelMapperService modelMapperService;
    private final IDepartmentsService departmentsService;
    private final IRoleService roleService;
    private final ILeaveTypeService leaveTypeService;
    

    @Autowired
    public MainPageController(IUserService userService,
                              IModelMapperService modelMapperService,
                              IDepartmentsService departmentsService,
                              IRoleService roleService,
                              ILeaveTypeService leaveTypeService,
                              IPayrollRecordsService payrollRecordsService) {
        this.userService = userService;
        this.modelMapperService = modelMapperService;
        this.departmentsService = departmentsService;
        this.roleService = roleService;
        this.leaveTypeService = leaveTypeService;
        
    }

    @GetMapping({"/", "/main"})
    public String mainPage() {
        return "main";
    }

    @GetMapping("/users")
    public String usersPage(Model model) {
        List<UserResponse> users = userService.getAll().stream()
                .map(user -> modelMapperService.forResponse().map(user, UserResponse.class))
                .collect(Collectors.toList());

        List<DepartmentResponse> departments = departmentsService.getAll().stream()
                .map(dept -> modelMapperService.forResponse().map(dept, DepartmentResponse.class))
                .collect(Collectors.toList());

        List<RoleResponse> roles = roleService.getAll().stream()
                .map(role -> modelMapperService.forResponse().map(role, RoleResponse.class))
                .collect(Collectors.toList());

        model.addAttribute("users", users);
        model.addAttribute("departments", departments);
        model.addAttribute("roles", roles);
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

    
}
