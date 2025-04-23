package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IDocumentTypeService;
import com.HRManagementInformation.dao.DocumentTypeRepository;
import com.HRManagementInformation.entities.DocumentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeManager implements IDocumentTypeService {
    private final DocumentTypeRepository repository;

    
    public DocumentTypeManager(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DocumentType save(DocumentType documentType) {
        return repository.save(documentType);
    }

    @Override
    public DocumentType get(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public DocumentType update(DocumentType documentType) {
        return repository.save(documentType);
    }

    @Override
    public List<DocumentType> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean delete(int id) {
        DocumentType documentType = this.get(id);
        repository.delete(documentType);
        return true;
    }
}
