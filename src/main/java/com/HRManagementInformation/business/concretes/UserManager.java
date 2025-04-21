package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IUserService;
import com.HRManagementInformation.dao.UserRepository;
import com.HRManagementInformation.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements IUserService {
    @Autowired
    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        User user = this.get(id);
        userRepository.delete(user);
        return true;
    }
}
