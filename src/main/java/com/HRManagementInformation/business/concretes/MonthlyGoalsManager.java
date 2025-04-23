package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IMonthlyGoalsService;
import com.HRManagementInformation.dao.MonthlyGoalsRepository;
import com.HRManagementInformation.entities.MonthlyGoals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthlyGoalsManager implements IMonthlyGoalsService {
    @Autowired
    private final MonthlyGoalsRepository monthlyGoalsRepository;

    public MonthlyGoalsManager(MonthlyGoalsRepository monthlyGoalsRepository) {
        this.monthlyGoalsRepository = monthlyGoalsRepository;
    }

    @Override
    public MonthlyGoals save(MonthlyGoals monthlyGoals) {
        return monthlyGoalsRepository.save(monthlyGoals);
    }

    @Override
    public MonthlyGoals get(int id) {
        return monthlyGoalsRepository.findById(id).orElseThrow();
    }

    @Override
    public MonthlyGoals update(MonthlyGoals monthlyGoals) {
        return monthlyGoalsRepository.save(monthlyGoals);
    }

    @Override
    public List<MonthlyGoals> getAll() {
        return monthlyGoalsRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        MonthlyGoals monthlyGoals = this.get(id);
        monthlyGoalsRepository.delete(monthlyGoals);
        return true;
    }
}