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
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/departments")
    public String departmentsPage(Model model) {
        List<Department> allDepartments = departmentsService.getAll();
        List<DepartmentResponse> departments = allDepartments.stream()
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
        List<Role> allRoles = roleService.getAll();
        List<RoleResponse> roles = allRoles.stream()
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
} 