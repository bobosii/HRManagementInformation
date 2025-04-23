package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IRecruitmentService;
import com.HRManagementInformation.dao.RecruitmentRepository;
import com.HRManagementInformation.entities.Recruitment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentManager implements IRecruitmentService {
    @Autowired
    private final RecruitmentRepository recruitmentRepository;

    public RecruitmentManager(RecruitmentRepository recruitmentRepository) {
        this.recruitmentRepository = recruitmentRepository;
    }

    @Override
    public Recruitment save(Recruitment recruitment) {
        return this.recruitmentRepository.save(recruitment);
    }

    @Override
    public Recruitment get(int recruitmentId) {
        return recruitmentRepository.findById(recruitmentId).orElseThrow();
    }

    @Override
    public Recruitment update(Recruitment recruitment) {
        return recruitmentRepository.save(recruitment);
    }

    @Override
    public List<Recruitment> getAll() {
        return recruitmentRepository.findAll();
    }

    @Override
    public boolean delete(int recruitmentId) {
        Recruitment recruitment = this.get(recruitmentId);
        recruitmentRepository.delete(recruitment);
        return true;
    }
}
