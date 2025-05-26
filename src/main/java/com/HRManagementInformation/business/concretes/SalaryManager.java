package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.ISalaryService;
import com.HRManagementInformation.business.abstracts.IUserService;
import com.HRManagementInformation.dao.SalaryRepository;
import com.HRManagementInformation.entities.Salary;
import com.HRManagementInformation.entities.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryManager implements ISalaryService {
    @Autowired
    private final SalaryRepository salaryRepository;
    @Autowired
    private final IUserService userService;

    public SalaryManager(SalaryRepository salaryRepository, IUserService userService) {
        this.salaryRepository = salaryRepository;
        this.userService = userService;
    }

    @Override
    public Salary save(Salary salary) {
        try {
            if (salary == null) {
                throw new IllegalArgumentException("Salary cannot be null");
            }
            
            if (salary.getUser() == null) {
                throw new IllegalArgumentException("User cannot be null");
            }
            
            User user = userService.get(salary.getUser().getId());
            if (user == null) {
                throw new EntityNotFoundException("User not found with ID: " + salary.getUser().getId());
            }
            
            salary.setUser(user);
            return this.salaryRepository.save(salary);
        } catch (Exception e) {
            throw new RuntimeException("Error saving salary: " + e.getMessage(), e);
        }
    }

    @Override
    public Salary get(int id) {
        return this.salaryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Salary not found with ID: " + id
        ));
    }

    @Override
    public Salary update(Salary salary) {
        try {
            Salary existingSalary = this.get(salary.getId());
            User user = userService.get(salary.getUser().getId());
            if (user == null) {
                throw new EntityNotFoundException("User not found with ID: " + salary.getUser().getId());
            }
            
            existingSalary.setSalaryAmount(salary.getSalaryAmount());
            existingSalary.setPaymentDate(salary.getPaymentDate());
            existingSalary.setUser(user);
            
            return this.salaryRepository.save(existingSalary);
        } catch (Exception e) {
            throw new RuntimeException("Error updating salary: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Salary> getAll() {
        return this.salaryRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        try {
            Salary salary = this.get(id);
            this.salaryRepository.delete(salary);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting salary: " + e.getMessage(), e);
        }
    }
}
