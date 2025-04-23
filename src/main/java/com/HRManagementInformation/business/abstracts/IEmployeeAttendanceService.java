package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.EmployeeAttendance;
import java.util.List;

public interface IEmployeeAttendanceService {
    EmployeeAttendance save(EmployeeAttendance employeeAttendance);
    EmployeeAttendance get(int id);
    EmployeeAttendance update(EmployeeAttendance employeeAttendance);
    List<EmployeeAttendance> getAll();
    boolean delete(int id);
}