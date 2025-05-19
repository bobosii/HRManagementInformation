package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IUserService;
import com.HRManagementInformation.business.abstracts.IDepartmentsService;
import com.HRManagementInformation.business.abstracts.IRoleService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.dto.response.UserResponse;
import com.HRManagementInformation.dto.response.DepartmentResponse;
import com.HRManagementInformation.dto.response.RoleResponse;
import com.HRManagementInformation.entities.User;
import com.HRManagementInformation.entities.Department;
import com.HRManagementInformation.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainPageController {
    private final IUserService userService;
    private final IModelMapperService modelMapperService;
    private final IDepartmentsService departmentsService;
    private final IRoleService roleService;

    @Autowired
    public MainPageController(IUserService userService, IModelMapperService modelMapperService, IDepartmentsService departmentsService, IRoleService roleService) {
        this.userService = userService;
        this.modelMapperService = modelMapperService;
        this.departmentsService = departmentsService;
        this.roleService = roleService;
    }

    @GetMapping({"/", "/main"})
    public String mainPage() {
        return "main";
    }

    @GetMapping("/users")
    public String usersPage(Model model) {
        List<User> allUsers = userService.getAll();
        List<UserResponse> users = allUsers.stream()
                .map(user -> modelMapperService.forResponse().map(user, UserResponse.class))
                .collect(Collectors.toList());
        List<Department> allDepartments = departmentsService.getAll();
        List<DepartmentResponse> departments = allDepartments.stream()
                .map(dept -> modelMapperService.forResponse().map(dept, DepartmentResponse.class))
                .collect(Collectors.toList());
        List<Role> allRoles = roleService.getAll();
        List<RoleResponse> roles = allRoles.stream()
                .map(role -> modelMapperService.forResponse().map(role, RoleResponse.class))
                .collect(Collectors.toList());
        model.addAttribute("users", users);
        model.addAttribute("departments", departments);
        model.addAttribute("roles", roles);
        return "users";
    }
} 