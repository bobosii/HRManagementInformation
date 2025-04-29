package com.HRManagementInformation.business.abstracts;
import com.HRManagementInformation.entities.Department;

import java.util.List;

public interface IDepartmentsService {
    Department save(Department department);
    Department get(int id);
    Department update(Department department);
    List<Department> getAll();
    boolean delete(int id);
}
