package com.HRManagementInformation.business.abstracts;

import com.HRManagementInformation.entities.User;

import java.util.List;

public interface IUserService {
    User save(User user);
    User get(int id);
    User update(User user);
    List<User> getAll();
    boolean delete(int id);
    User getById(int id);

}
