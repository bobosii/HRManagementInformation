package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.PayrollRecord;

import java.util.List;

public interface IPayrollRecordsService {
    PayrollRecord save(PayrollRecord payrollRecord);
    PayrollRecord get(int id);
    PayrollRecord update(PayrollRecord payrollRecord);
    List<PayrollRecord> getAll();
    boolean delete(int id);
}
