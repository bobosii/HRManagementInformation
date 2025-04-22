package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.MonthlyGoals;
import java.util.List;

public interface IMonthlyGoalsService {
    MonthlyGoals save(MonthlyGoals monthlyGoals);
    MonthlyGoals get(int id);
    MonthlyGoals update(MonthlyGoals monthlyGoals);
    List<MonthlyGoals> getAll();
    boolean delete(int id);
}