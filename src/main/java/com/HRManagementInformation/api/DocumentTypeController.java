package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IDocumentTypeService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.DocumentTypeSaveRequest;
import com.HRManagementInformation.dto.request.DocumentTypeUpdateRequest;
import com.HRManagementInformation.dto.response.DocumentTypeResponse;
import com.HRManagementInformation.entities.DocumentType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/document-types")
public class DocumentTypeController {

    private final IDocumentTypeService documentTypeService;
    private final IModelMapperService modelMapperService;

    public DocumentTypeController(IDocumentTypeService documentTypeService, IModelMapperService modelMapperService) {
        this.documentTypeService = documentTypeService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<DocumentTypeResponse>> getAll() {
        List<DocumentType> documentTypes = documentTypeService.getAll();
        List<DocumentTypeResponse> responseList = documentTypes.stream()
                .map(dt -> modelMapperService.forResponse().map(dt, DocumentTypeResponse.class))
                .collect(Collectors.toList());
        return ResultHelper.success(responseList);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DocumentTypeResponse> getById(@PathVariable("id") int id) {
        DocumentType documentType = documentTypeService.get(id);
        return ResultHelper.success(modelMapperService.forResponse().map(documentType, DocumentTypeResponse.class));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<DocumentTypeResponse> save(@RequestBody DocumentTypeSaveRequest request) {
        DocumentType entity = modelMapperService.forRequest().map(request, DocumentType.class);
        DocumentType saved = documentTypeService.save(entity);
        return ResultHelper.created(modelMapperService.forResponse().map(saved, DocumentTypeResponse.class));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DocumentTypeResponse> update(@PathVariable("id") int id, @RequestBody DocumentTypeUpdateRequest request) {
        DocumentType existing = documentTypeService.get(id);
        modelMapperService.forRequest().map(request, existing);
        documentTypeService.update(existing);
        return ResultHelper.success(modelMapperService.forResponse().map(existing, DocumentTypeResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        documentTypeService.delete(id);
        return ResultHelper.ok();
    }
}
