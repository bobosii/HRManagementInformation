package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IInsuranceTypeService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.insuranceType.InsuranceTypeSaveRequest;
import com.HRManagementInformation.dto.request.insuranceType.InsuranceTypeUpdateRequest;
import com.HRManagementInformation.dto.response.InsuranceTypeResponse;
import com.HRManagementInformation.entities.InsuranceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/insurancetype")
public class InsuranceTypeController {
    @Autowired
    private final IInsuranceTypeService insuranceTypeService;
    @Autowired
    private final IModelMapperService modelMapperService;

    public InsuranceTypeController(IInsuranceTypeService insuranceTypeService, IModelMapperService modelMapperService) {
        this.insuranceTypeService = insuranceTypeService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<InsuranceTypeResponse>> getAllInsuranceTypes(){
        List<InsuranceType> insuranceTypes = this.insuranceTypeService.getAll();
        List<InsuranceTypeResponse> insuranceTypeResponses = insuranceTypes.stream()
                .map(types -> this.modelMapperService.forResponse()
                        .map(types,InsuranceTypeResponse.class))
                .collect(Collectors.toList());
        return ResultHelper.success(insuranceTypeResponses);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<InsuranceTypeResponse> getInsuranceTypeById(@PathVariable("id") int id){
        InsuranceType insuranceType = this.insuranceTypeService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(insuranceType,InsuranceTypeResponse.class));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<InsuranceTypeResponse> createInsuranceType(@RequestBody InsuranceTypeSaveRequest insuranceTypeSaveRequest){
        this.insuranceTypeService.save(this.modelMapperService.forRequest().map(insuranceTypeSaveRequest,InsuranceType.class));
        return ResultHelper.created(this.modelMapperService.forResponse().map(insuranceTypeSaveRequest, InsuranceTypeResponse.class));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<InsuranceTypeResponse> updateInsuranceType(
            @PathVariable("id") int id,
            @RequestBody InsuranceTypeUpdateRequest insuranceTypeUpdateRequest
            ){
        InsuranceType insuranceType = this.insuranceTypeService.get(id);
        this.modelMapperService.forRequest().map(insuranceTypeUpdateRequest,insuranceType);
        this.insuranceTypeService.update(insuranceType);

        return ResultHelper.updated(this.modelMapperService.forResponse().map(insuranceType,InsuranceTypeResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteInsuranceType(@PathVariable("id") int id){
        this.insuranceTypeService.delete(id);
        return ResultHelper.deleted();
    }
}
