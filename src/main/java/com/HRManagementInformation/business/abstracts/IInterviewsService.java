package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.Interviews;

import java.util.List;

public interface IInterviewsService {
    Interviews save(Interviews interview);
    Interviews get(int interviewId);
    Interviews update(Interviews interview);
    List<Interviews> getAll();
    boolean delete(int interviewId);
}
