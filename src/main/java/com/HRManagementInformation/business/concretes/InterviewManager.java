package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IInterviewsService;
import com.HRManagementInformation.dao.InterviewRepository;
import com.HRManagementInformation.entities.Interviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewManager implements IInterviewsService {
    @Autowired
    private final InterviewRepository interviewRepository;

    public InterviewManager(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    @Override
    public Interviews save(Interviews interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public Interviews get(int interviewId) {
        return interviewRepository.findById(interviewId).orElseThrow();
    }

    @Override
    public Interviews update(Interviews interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public List<Interviews> getAll() {
        return interviewRepository.findAll();
    }

    @Override
    public boolean delete(int interviewId) {
        Interviews interview = this.get(interviewId);
        interviewRepository.delete(interview);
        return true;
    }
}
