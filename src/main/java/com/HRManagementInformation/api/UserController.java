package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IUserService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.user.UserSaveRequest;
import com.HRManagementInformation.dto.request.user.UserUpdateRequest;
import com.HRManagementInformation.dto.response.UserResponse;
import com.HRManagementInformation.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final IUserService userService;
    private final IModelMapperService modelMapperService;

    public UserController(IUserService userService, IModelMapperService modelMapperService) {
        this.userService = userService;
        this.modelMapperService = modelMapperService;
    }

    // 🔹 Get all users
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<UserResponse>> getAllUsers() {
        List<User> allUsers = userService.getAll();

        List<UserResponse> userResponses = allUsers.stream()
                .map(user -> {
                    UserResponse res = new UserResponse();
                    res.setId(user.getId());
                    res.setFirstName(user.getFirstName());
                    res.setLastName(user.getLastName());
                    res.setEmail(user.getEmail());
                    res.setPhone(user.getPhone());
                    res.setTcNo(user.getTcNo());
                    res.setHireDate(user.getHireDate());
                    res.setBirthDate(user.getBirthDate());
                    res.setRoleName(user.getRole() != null ? user.getRole().getTitle() : "Yok");
                    res.setDepartmentName(user.getDepartment() != null ? user.getDepartment().getName() : "Yok");
                    return res;
                })
                .collect(Collectors.toList());

        return ResultHelper.success(userResponses);
    }

    // 🔹 Get user by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<UserResponse> getUserById(@PathVariable("id") int id) {
        User user = this.userService.get(id);

        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setFirstName(user.getFirstName());
        res.setLastName(user.getLastName());
        res.setEmail(user.getEmail());
        res.setPhone(user.getPhone());
        res.setTcNo(user.getTcNo());
        res.setHireDate(user.getHireDate());
        res.setBirthDate(user.getBirthDate());
        res.setRoleName(user.getRole() != null ? user.getRole().getTitle() : "Yok");
        res.setDepartmentName(user.getDepartment() != null ? user.getDepartment().getName() : "Yok");

        return ResultHelper.success(res);
    }

    // 🔹 Save user
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<UserResponse> saveUser(@RequestBody UserSaveRequest userSaveRequest) {
        User saveUser = this.modelMapperService.forRequest().map(userSaveRequest, User.class);
        this.userService.save(saveUser);

        // Optional: elle mapping
        UserResponse res = new UserResponse();
        res.setId(saveUser.getId());
        res.setFirstName(saveUser.getFirstName());
        res.setLastName(saveUser.getLastName());
        res.setEmail(saveUser.getEmail());
        res.setPhone(saveUser.getPhone());
        res.setTcNo(saveUser.getTcNo());
        res.setHireDate(saveUser.getHireDate());
        res.setBirthDate(saveUser.getBirthDate());
        res.setRoleName(saveUser.getRole() != null ? saveUser.getRole().getTitle() : "Yok");
        res.setDepartmentName(saveUser.getDepartment() != null ? saveUser.getDepartment().getName() : "Yok");

        return ResultHelper.created(res);
    }

    // 🔹 Update user
    @PutMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<UserResponse> updateUser(
            @PathVariable("user-id") int userId,
            @RequestBody UserUpdateRequest userUpdateRequest) {

        User existingUser = this.userService.get(userId);
        this.modelMapperService.forRequest().map(userUpdateRequest, existingUser);
        this.userService.update(existingUser);

        UserResponse res = new UserResponse();
        res.setId(existingUser.getId());
        res.setFirstName(existingUser.getFirstName());
        res.setLastName(existingUser.getLastName());
        res.setEmail(existingUser.getEmail());
        res.setPhone(existingUser.getPhone());
        res.setTcNo(existingUser.getTcNo());
        res.setHireDate(existingUser.getHireDate());
        res.setBirthDate(existingUser.getBirthDate());
        res.setRoleName(existingUser.getRole() != null ? existingUser.getRole().getTitle() : "Yok");
        res.setDepartmentName(existingUser.getDepartment() != null ? existingUser.getDepartment().getName() : "Yok");

        return ResultHelper.success(res);
    }

    // 🔹 Delete user
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return ResultHelper.ok();
    }
}
