package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.LeaveType;
import java.util.List;

public interface ILeaveTypeService {
    LeaveType save(LeaveType leaveType);
    LeaveType get(int id);
    LeaveType update(LeaveType leaveType);
    List<LeaveType> getAll();
    boolean delete(int id);
}
