package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.ExitRecord;
import java.util.List;

public interface IExitRecordService {
    ExitRecord save(ExitRecord exitRecord);
    ExitRecord get(int id);
    ExitRecord update(ExitRecord exitRecord);
    List<ExitRecord> getAll();
    boolean delete(int id);
}
