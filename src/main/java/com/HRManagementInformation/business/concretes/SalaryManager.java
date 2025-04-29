package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.ISalaryService;
import com.HRManagementInformation.dao.SalaryRepository;
import com.HRManagementInformation.entities.Salary;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryManager implements ISalaryService {
    @Autowired
    private final SalaryRepository salaryRepository;

    public SalaryManager(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public Salary save(Salary salary) {
        return this.salaryRepository.save(salary);
    }

    @Override
    public Salary get(int id) {
        return this.salaryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Department not found with ID: " + id
        ));
    }

    @Override
    public Salary update(Salary salary) {
        // If it does not exist. It can be throw error
        Salary updatedSalary = this.get(salary.getId());
        return this.update(updatedSalary);
    }

    @Override
    public List<Salary> getAll() {
        return this.salaryRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        Salary salary = this.get(id);
        this.salaryRepository.delete(salary);
        return true;
    }
}
