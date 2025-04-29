package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IDepartmentsService;
import com.HRManagementInformation.dao.DepartmentRepository;
import com.HRManagementInformation.entities.Department;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsManager implements IDepartmentsService {
    @Autowired
    private final DepartmentRepository departmentRepository;

    public DepartmentsManager(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department get(int id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with ID: " + id));
    }

    @Override
    public Department update(Department departments) {
        // if does not exist, it can be throw error
        Department department = this.get(departments.getId());
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        Department department = this.get(id);
        departmentRepository.delete(department);
        return true;
    }
}
