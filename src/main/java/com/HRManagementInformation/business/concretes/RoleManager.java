package com.HRManagementInformation.business.concretes;

import com.HRManagementInformation.business.abstracts.IRoleService;
import com.HRManagementInformation.dao.RoleRepository;
import com.HRManagementInformation.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleManager implements IRoleService {
    @Autowired
    private final RoleRepository roleRepository;

    public RoleManager(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role get(int id) {
        return this.roleRepository.findById(id).orElseThrow();
    }

    @Override
    public Role update(Role role) {
        Role updateRole = this.get(role.getId());
        return this.roleRepository.save(updateRole);
    }

    @Override
    public List<Role> getAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        Role deleteRole = this.get(id);
        this.roleRepository.delete(deleteRole);
        return true;
    }
}
