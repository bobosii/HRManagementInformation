package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IPayrollRecordsService;
import com.HRManagementInformation.business.abstracts.IUserService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.payrollRecord.PayrollRecordRequest;
import com.HRManagementInformation.dto.response.PayrollRecordsResponse;
import com.HRManagementInformation.entities.PayrollRecord;
import com.HRManagementInformation.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/payroll")
public class PayrollRecordsController {
    @Autowired
    private final IPayrollRecordsService payrollRecordsService;
    @Autowired
    private IModelMapperService modelMapperService;
    @Autowired
    private final IUserService userService;

    public PayrollRecordsController(IPayrollRecordsService payrollRecordsService, IUserService userService) {
        this.payrollRecordsService = payrollRecordsService;
        this.userService = userService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<PayrollRecordsResponse>> getAllPayrolls(){
        List<PayrollRecord> allPayrollRecords = payrollRecordsService.getAll();

        List<PayrollRecordsResponse> payrollRecordsResponses = allPayrollRecords.stream()
                .map(payrolls -> modelMapperService.forResponse().map(payrolls, PayrollRecordsResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(payrollRecordsResponses);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PayrollRecordsResponse> getRecordsById(@PathVariable("id") int id){
        PayrollRecord payrollRecord = this.payrollRecordsService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(payrollRecord, PayrollRecordsResponse.class));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<PayrollRecordsResponse> savePayroll(@RequestBody PayrollRecordRequest payrollRecordRequest){
        // Define User.
        User user = userService.get(payrollRecordRequest.getUserId());
        PayrollRecord payrollRecord = modelMapperService.forRequest().map(payrollRecordRequest, PayrollRecord.class);
        payrollRecord.setUser(user);
        payrollRecordsService.save(payrollRecord);

        PayrollRecordsResponse response = this.modelMapperService.forResponse()
                .map(payrollRecord, PayrollRecordsResponse.class);

        return ResultHelper.created(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PayrollRecordsResponse> updatePayrolls(
            @PathVariable("id") int id,
            @RequestBody PayrollRecordRequest payrollRecordRequest) {

        PayrollRecord existingRecord = payrollRecordsService.get(id);

        User user = userService.get(payrollRecordRequest.getUserId());

        existingRecord.setUser(user);
        existingRecord.setPayroll_date(payrollRecordRequest.getPayrollDate());
        existingRecord.setBase_salary(payrollRecordRequest.getBaseSalary());
        existingRecord.setBonuses(payrollRecordRequest.getBonuses());
        existingRecord.setDeductions(payrollRecordRequest.getDeductions());
        existingRecord.setNetSalary(payrollRecordRequest.getNetSalary());

        payrollRecordsService.update(existingRecord);

        PayrollRecordsResponse response = modelMapperService.forResponse()
                .map(existingRecord, PayrollRecordsResponse.class);

        return ResultHelper.success(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deletePayroll(@PathVariable("id") int id){
        this.payrollRecordsService.delete(id);
        return ResultHelper.deleted();
    }
}
