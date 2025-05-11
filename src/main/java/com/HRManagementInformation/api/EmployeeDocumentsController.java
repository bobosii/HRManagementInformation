package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IEmployeeDocumentsService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.employee.EmployeeDocumentsSaveRequest;
import com.HRManagementInformation.dto.request.employee.EmployeeDocumentsUpdateRequest;
import com.HRManagementInformation.dto.response.EmployeeDocumentsResponse;
import com.HRManagementInformation.entities.EmployeeDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/documents")
public class EmployeeDocumentsController {
    @Autowired
    private final IEmployeeDocumentsService employeeDocumentsService;
    @Autowired
    private final IModelMapperService modelMapperService;

    public EmployeeDocumentsController(IEmployeeDocumentsService employeeDocumentsService, IModelMapperService modelMapperService) {
        this.employeeDocumentsService = employeeDocumentsService;
        this.modelMapperService = modelMapperService;
    }

    // Get all documents
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<EmployeeDocumentsResponse>> getAllDocuments() {
        List<EmployeeDocuments> allDocuments = employeeDocumentsService.getAll();

        List<EmployeeDocumentsResponse> documentResponses = allDocuments.stream()
                .map(document -> modelMapperService.forResponse().map(document, EmployeeDocumentsResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(documentResponses);
    }

    // Get document by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<EmployeeDocumentsResponse> getDocumentById(@PathVariable("id") int id) {
        EmployeeDocuments document = this.employeeDocumentsService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(document, EmployeeDocumentsResponse.class));
    }

    // Save document
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<EmployeeDocumentsResponse> saveDocument(@RequestBody EmployeeDocumentsSaveRequest documentSaveRequest) {
        EmployeeDocuments saveDocument = this.modelMapperService.forRequest().map(documentSaveRequest, EmployeeDocuments.class);
        this.employeeDocumentsService.save(saveDocument);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveDocument, EmployeeDocumentsResponse.class));
    }

    // Update document
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<EmployeeDocumentsResponse> updateDocument(
            @PathVariable("id") int id,
            @RequestBody EmployeeDocumentsUpdateRequest documentUpdateRequest) {
        EmployeeDocuments existingDocument = this.employeeDocumentsService.get(id);
        this.modelMapperService.forRequest().map(documentUpdateRequest, existingDocument);
        this.employeeDocumentsService.update(existingDocument);

        return ResultHelper.updated(this.modelMapperService.forResponse().map(existingDocument, EmployeeDocumentsResponse.class));
    }

    // Delete document
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteDocument(@PathVariable("id") int id) {
        employeeDocumentsService.delete(id);
        return ResultHelper.ok();
    }
}