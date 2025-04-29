package com.HRManagementInformation.business.abstracts;


import com.HRManagementInformation.entities.Role;

import java.util.List;

public interface IRoleService {
    Role save(Role role);
    Role get(int id);
    Role update(Role role);
    List<Role> getAll();
    boolean delete(int id);
}
