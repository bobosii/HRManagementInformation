package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IPayrollRecordsService;
import com.HRManagementInformation.dao.PayrollRecordsRepository;
import com.HRManagementInformation.entities.PayrollRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollRecordsManager implements IPayrollRecordsService {
    @Autowired
    private final PayrollRecordsRepository payrollRecordsRepository;

    public PayrollRecordsManager(PayrollRecordsRepository payrollRecordsRepository) {
        this.payrollRecordsRepository = payrollRecordsRepository;
    }

    @Override
    public PayrollRecord save(PayrollRecord payrollRecord) {
        return payrollRecordsRepository.save(payrollRecord);
    }

    @Override
    public PayrollRecord get(int id) {
        return payrollRecordsRepository.findById(id).orElseThrow();
    }

    @Override
    public PayrollRecord update(PayrollRecord payrollRecord) {
        return payrollRecordsRepository.save(payrollRecord);
    }

    @Override
    public List<PayrollRecord> getAll() {
        return payrollRecordsRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        PayrollRecord payrollRecord = this.get(id);
        payrollRecordsRepository.delete(payrollRecord);
        return true;
    }
}
