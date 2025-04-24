package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.LeaveRequest;
import java.util.List;

public interface ILeaveRequestService {
    LeaveRequest save(LeaveRequest leaveRequest);
    LeaveRequest get(int id);
    LeaveRequest update(LeaveRequest leaveRequest);
    List<LeaveRequest> getAll();
    boolean delete(int id);
}
