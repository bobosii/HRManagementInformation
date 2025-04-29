package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.Role;
import com.HRManagementInformation.entities.Salary;

import java.util.List;

public interface ISalaryService {
    Salary save(Salary salary);
    Salary get(int id);
    Salary update(Salary salary);
    List<Salary> getAll();
    boolean delete(int id);
}
