package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IEmployeeDocumentsService;
import com.HRManagementInformation.dao.EmployeeDocumentsRepository;
import com.HRManagementInformation.entities.EmployeeDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDocumentsManager implements IEmployeeDocumentsService {
    @Autowired
    private final EmployeeDocumentsRepository employeeDocumentsRepository;

    public EmployeeDocumentsManager(EmployeeDocumentsRepository employeeDocumentsRepository) {
        this.employeeDocumentsRepository = employeeDocumentsRepository;
    }

    @Override
    public EmployeeDocuments save(EmployeeDocuments employeeDocuments) {
        return employeeDocumentsRepository.save(employeeDocuments);
    }

    @Override
    public EmployeeDocuments get(int id) {
        return employeeDocumentsRepository.findById(id).orElseThrow();
    }

    @Override
    public EmployeeDocuments update(EmployeeDocuments employeeDocuments) {
        return employeeDocumentsRepository.save(employeeDocuments);
    }

    @Override
    public List<EmployeeDocuments> getAll() {
        return employeeDocumentsRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        EmployeeDocuments employeeDocuments = this.get(id);
        employeeDocumentsRepository.delete(employeeDocuments);
        return true;
    }
}