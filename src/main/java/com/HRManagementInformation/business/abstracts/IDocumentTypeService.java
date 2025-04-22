package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.DocumentType;

import java.util.List;

public interface IDocumentTypeService {
    DocumentType save(DocumentType documentType);
    DocumentType get(int id);
    DocumentType update(DocumentType documentType);
    List<DocumentType> getAll();
    boolean delete(int id);
}
