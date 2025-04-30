package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IExitRecordService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.exitRecord.ExitRecordSaveRequest;
import com.HRManagementInformation.dto.response.ExitRecordResponse;
import com.HRManagementInformation.entities.ExitRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/exitrecord")
public class ExitRecordController {
    @Autowired
    private final IExitRecordService exitRecordService;
    @Autowired
    private final IModelMapperService modelMapperService;


    public ExitRecordController(IExitRecordService exitRecordService, IModelMapperService modelMapperService) {
        this.exitRecordService = exitRecordService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<ExitRecordResponse>> getAllExitRecords(){
        List<ExitRecord> exitRecords = this.exitRecordService.getAll();
        List<ExitRecordResponse> exitRecordResponses = exitRecords.stream()
                .map(record -> this.modelMapperService.forResponse().map(record, ExitRecordResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(exitRecordResponses);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<ExitRecordResponse> getExitRecord(@PathVariable("id") int id){
        ExitRecord exitRecord = this.exitRecordService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(exitRecord, ExitRecordResponse.class));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<ExitRecordResponse> saveExitRecord(@RequestBody ExitRecordSaveRequest saveRequest){
        ExitRecord saveRecord = this.modelMapperService.forRequest().map(saveRequest, ExitRecord.class);
        this.exitRecordService.save(saveRecord);

        return ResultHelper.created(this.modelMapperService.forResponse().map(saveRequest, ExitRecordResponse.class));
    }

    // todo PutMapping (Update)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteExitRecord(@PathVariable("id") int id){
        this.exitRecordService.delete(id);
        return ResultHelper.deleted();
    }
}
