package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.Recruitment;

import java.util.List;

public interface IRecruitmentService {
    Recruitment save (Recruitment recruitment);
    Recruitment get(int recruitmentId);
    Recruitment update(Recruitment recruitment);
    List<Recruitment> getAll();
    boolean delete(int recruitmentId);
}
