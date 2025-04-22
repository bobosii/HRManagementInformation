package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.EmployeeDocuments;
import java.util.List;

public interface IEmployeeDocumentsService {
    EmployeeDocuments save(EmployeeDocuments employeeDocuments);
    EmployeeDocuments get(int id);
    EmployeeDocuments update(EmployeeDocuments employeeDocuments);
    List<EmployeeDocuments> getAll();
    boolean delete(int id);
}