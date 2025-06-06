package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.ILeaveTypeService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.leaveType.LeaveTypeSaveRequest;
import com.HRManagementInformation.dto.request.leaveType.LeaveTypeUpdateRequest;
import com.HRManagementInformation.dto.response.LeaveTypeResponse;
import com.HRManagementInformation.entities.LeaveType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/leave-types")
public class LeaveTypeController {

    private final ILeaveTypeService leaveTypeService;
    private final IModelMapperService modelMapperService;

    public LeaveTypeController(ILeaveTypeService leaveTypeService, IModelMapperService modelMapperService) {
        this.leaveTypeService = leaveTypeService;
        this.modelMapperService = modelMapperService;
    }

    // ✅ HTML SAYFASI - Listeleme + form
    @GetMapping
    public String listLeaveTypes(Model model) {
        List<LeaveType> leaveTypes = leaveTypeService.getAll();
        model.addAttribute("leaveTypes", leaveTypes);
        model.addAttribute("newLeaveType", new LeaveType());
        return "leave-types";
    }

    // ✅ HTML SAYFASI - Ekleme
    @PostMapping("/add")
    public String addLeaveType(@ModelAttribute("newLeaveType") LeaveType leaveType) {
        leaveTypeService.save(leaveType);
        return "redirect:/leave-types";
    }

    // ✅ HTML SAYFASI - Güncelleme (satır içi formdan)
    @PostMapping("/update/{id}")
    public String updateLeaveType(@PathVariable int id, @ModelAttribute LeaveType updatedLeaveType) {
        LeaveType existing = leaveTypeService.get(id);
        existing.setLeaveTypeName(updatedLeaveType.getLeaveTypeName());
        existing.setDescription(updatedLeaveType.getDescription());
        leaveTypeService.update(existing);
        return "redirect:/leave-types";
    }

    // ✅ HTML SAYFASI - Silme
    @GetMapping("/delete/{id}")
    public String deleteLeaveType(@PathVariable int id) {
        leaveTypeService.delete(id);
        return "redirect:/leave-types";
    }

    // ✅ JSON API - Listeleme
    @ResponseBody
    @GetMapping("/api")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<LeaveTypeResponse>> getAll() {
        List<LeaveType> leaveTypes = leaveTypeService.getAll();
        List<LeaveTypeResponse> responseList = leaveTypes.stream()
                .map(lt -> modelMapperService.forResponse().map(lt, LeaveTypeResponse.class))
                .collect(Collectors.toList());
        return ResultHelper.success(responseList);
    }

    // ✅ JSON API - Get by ID
    @ResponseBody
    @GetMapping("/api/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<LeaveTypeResponse> getById(@PathVariable("id") int id) {
        LeaveType leaveType = leaveTypeService.get(id);
        return ResultHelper.success(modelMapperService.forResponse().map(leaveType, LeaveTypeResponse.class));
    }

    // ✅ JSON API - Kayıt Ekle
    @ResponseBody
    @PostMapping("/api")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<LeaveTypeResponse> save(@RequestBody LeaveTypeSaveRequest request) {
        LeaveType entity = modelMapperService.forRequest().map(request, LeaveType.class);
        LeaveType saved = leaveTypeService.save(entity);
        return ResultHelper.created(modelMapperService.forResponse().map(saved, LeaveTypeResponse.class));
    }

    // ✅ JSON API - Güncelleme
    @ResponseBody
    @PutMapping("/api/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<LeaveTypeResponse> update(@PathVariable("id") int id, @RequestBody LeaveTypeUpdateRequest request) {
        LeaveType existing = leaveTypeService.get(id);
        modelMapperService.forRequest().map(request, existing);
        leaveTypeService.update(existing);
        return ResultHelper.updated(modelMapperService.forResponse().map(existing, LeaveTypeResponse.class));
    }

    // ✅ JSON API - Silme
    @ResponseBody
    @DeleteMapping("/api/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        leaveTypeService.delete(id);
        return ResultHelper.ok();
    }
}
