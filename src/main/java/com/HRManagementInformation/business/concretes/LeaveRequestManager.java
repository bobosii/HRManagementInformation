package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.ILeaveRequestService;
import com.HRManagementInformation.dao.LeaveRequestRepository;
import com.HRManagementInformation.entities.LeaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestManager implements ILeaveRequestService {

    private final LeaveRequestRepository repository;

    public LeaveRequestManager(LeaveRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public LeaveRequest save(LeaveRequest leaveRequest) {
        return repository.save(leaveRequest);
    }

    @Override
    public LeaveRequest get(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public LeaveRequest update(LeaveRequest leaveRequest) {
        return repository.save(leaveRequest);
    }

    @Override
    public List<LeaveRequest> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean delete(int id) {
        LeaveRequest leaveRequest = this.get(id);
        repository.delete(leaveRequest);
        return true;
    }
}
