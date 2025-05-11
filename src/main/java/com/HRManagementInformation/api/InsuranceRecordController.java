package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IInsuranceRecordService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.insuranceRecord.InsuranceRecordSaveRequest;
import com.HRManagementInformation.dto.request.insuranceRecord.InsuranceRecordUpdateRequest;
import com.HRManagementInformation.dto.response.InsuranceRecordResponse;
import com.HRManagementInformation.entities.InsuranceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/insurancerecord")
public class InsuranceRecordController {
    @Autowired
    private final IInsuranceRecordService insuranceRecordService;
    @Autowired
    private final IModelMapperService modelMapperService;

    public InsuranceRecordController(IInsuranceRecordService insuranceRecordService, IModelMapperService modelMapperService) {
        this.insuranceRecordService = insuranceRecordService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<InsuranceRecordResponse>> getAllInsuranceRecord(){
        List<InsuranceRecord> recordList = this.insuranceRecordService.getAll();
        List<InsuranceRecordResponse> recordResponses = recordList.stream()
                .map(record -> this.modelMapperService.forResponse().map(record, InsuranceRecordResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(recordResponses);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<InsuranceRecordResponse> getInsuranceRecordById(@PathVariable("id") int id){
        InsuranceRecord insuranceRecord = this.insuranceRecordService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(insuranceRecord,InsuranceRecordResponse.class));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<InsuranceRecordResponse> createInsuranceRecord(@RequestBody InsuranceRecordSaveRequest insuranceRecordSaveRequest){
        InsuranceRecord saveRecord = this.modelMapperService.forRequest().map(insuranceRecordSaveRequest,InsuranceRecord.class);
        this.insuranceRecordService.save(saveRecord);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveRecord, InsuranceRecordResponse.class));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<InsuranceRecordResponse> updateInsuranceRecord(
            @PathVariable("id") int id,
            @RequestBody InsuranceRecordUpdateRequest insuranceRecordUpdateRequest){
        InsuranceRecord insuranceRecord = this.insuranceRecordService.get(id);
        this.modelMapperService.forRequest().map(insuranceRecordUpdateRequest,insuranceRecord);
        this.insuranceRecordService.update(insuranceRecord);

        return ResultHelper.success(this.modelMapperService.forResponse().map(insuranceRecord, InsuranceRecordResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteInsuranceRecord(@PathVariable("id") int id){
        this.insuranceRecordService.delete(id);
        return ResultHelper.deleted();
    }

}














