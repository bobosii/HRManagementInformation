package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IRoleService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.role.RoleRequest;
import com.HRManagementInformation.dto.response.RoleResponse;
import com.HRManagementInformation.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private final IRoleService roleService;
    @Autowired
    private final IModelMapperService modelMapperService;

    public RoleController(IRoleService roleService, IModelMapperService modelMapperService) {
        this.roleService = roleService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<RoleResponse>> getAllRoles(){
        List<Role> roles = this.roleService.getAll();

        List<RoleResponse> roleResponses = roles.stream()
                .map(role -> this.modelMapperService.forResponse()
                        .map(role, RoleResponse.class)).collect(Collectors.toList());

        return ResultHelper.success(roleResponses);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<RoleResponse> getRoleById(@PathVariable("id") int id){
        Role role = this.roleService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(role, RoleResponse.class));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<RoleResponse> saveRole(@RequestBody RoleRequest roleRequest){
        Role saveRole = this.modelMapperService.forRequest().map(roleRequest,Role.class);
        this.roleService.save(saveRole);

        return ResultHelper.created(this.modelMapperService.forResponse().map(saveRole, RoleResponse.class));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<RoleResponse> updateRole(
            @PathVariable("id") int id,
            @RequestBody RoleRequest roleRequest) {
        Role existingRole = this.roleService.get(id);
        this.modelMapperService.forRequest().map(roleRequest, existingRole);
        this.roleService.update(existingRole);

        return ResultHelper.success(this.modelMapperService.forResponse().map(existingRole, RoleResponse.class));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteRole(@PathVariable("id") int id){
        this.roleService.delete(id);
        return ResultHelper.deleted();
    }
}
