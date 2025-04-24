package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.ILeaveTypeService;
import com.HRManagementInformation.dao.LeaveTypeRepository;
import com.HRManagementInformation.entities.LeaveType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypeManager implements ILeaveTypeService {

    private final LeaveTypeRepository repository;

    public LeaveTypeManager(LeaveTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public LeaveType save(LeaveType leaveType) {
        return repository.save(leaveType);
    }

    @Override
    public LeaveType get(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public LeaveType update(LeaveType leaveType) {
        return repository.save(leaveType);
    }

    @Override
    public List<LeaveType> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean delete(int id) {
        LeaveType leaveType = this.get(id);
        repository.delete(leaveType);
        return true;
    }
}

