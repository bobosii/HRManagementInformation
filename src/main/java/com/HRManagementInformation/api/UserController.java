package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IUserService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.UserSaveRequest;
import com.HRManagementInformation.dto.request.UserUpdateRequest;
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

    // Get all users
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<UserResponse>> getAllUsers() {
        List<User> allUser = userService.getAll();

        List<UserResponse> userResponses = allUser.stream()
                .map(user -> modelMapperService.forResponse().map(user, UserResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(userResponses);
    }

    // Get user by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<UserResponse> getUserById(@PathVariable("id") int id) {
        User user = this.userService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(user, UserResponse.class));
    }

    // Save User
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<UserResponse> saveUser(@RequestBody UserSaveRequest userSaveRequest) {
        User saveUser = this.modelMapperService.forRequest().map(userSaveRequest, User.class);
        this.userService.save(saveUser);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveUser, UserResponse.class));
    }

    // Update User
    @PutMapping("/{user-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<UserResponse> updateUser(
            @PathVariable("user-id") int userId,
            @RequestBody UserUpdateRequest userUpdateRequest){
        User existingUser = this.userService.get(userId);
        this.modelMapperService.forRequest().map(userUpdateRequest, existingUser);
        this.userService.update(existingUser);

        return ResultHelper.success(this.modelMapperService.forResponse().map(existingUser, UserResponse.class));
    }
    // Delete User
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return ResultHelper.ok();
    }
}