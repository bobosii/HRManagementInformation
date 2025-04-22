package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IEmployeeAttendanceService;
import com.HRManagementInformation.dao.EmployeeAttendanceRepository;
import com.HRManagementInformation.entities.EmployeeAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAttendanceManager implements IEmployeeAttendanceService {
    @Autowired
    private final EmployeeAttendanceRepository employeeAttendanceRepository;

    public EmployeeAttendanceManager(EmployeeAttendanceRepository employeeAttendanceRepository) {
        this.employeeAttendanceRepository = employeeAttendanceRepository;
    }

    @Override
    public EmployeeAttendance save(EmployeeAttendance employeeAttendance) {
        return employeeAttendanceRepository.save(employeeAttendance);
    }

    @Override
    public EmployeeAttendance get(int id) {
        return employeeAttendanceRepository.findById(id).orElseThrow();
    }

    @Override
    public EmployeeAttendance update(EmployeeAttendance employeeAttendance) {
        return employeeAttendanceRepository.save(employeeAttendance);
    }

    @Override
    public List<EmployeeAttendance> getAll() {
        return employeeAttendanceRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        EmployeeAttendance employeeAttendance = this.get(id);
        employeeAttendanceRepository.delete(employeeAttendance);
        return true;
    }
}