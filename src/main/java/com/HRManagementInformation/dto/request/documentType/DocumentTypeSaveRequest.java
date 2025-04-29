package com.HRManagementInformation.dto.request.documentType;

import jakarta.validation.constraints.NotBlank;

public class DocumentTypeSaveRequest {

    @NotBlank(message = "Belge tipi adı boş olamaz.")
    private String typeName;

    private String description;

    public DocumentTypeSaveRequest() {}

    public DocumentTypeSaveRequest(String typeName, String description) {
        this.typeName = typeName;
        this.description = description;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
