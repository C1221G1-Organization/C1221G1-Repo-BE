package com.c1221g1.pharmacy.service.user.impl;

import com.c1221g1.pharmacy.entity.user.Roles;
import com.c1221g1.pharmacy.repository.user.IRoleRepository;
import com.c1221g1.pharmacy.service.user.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository iRoleRepository;

    @Override
    public Roles findRole(String roleManager) {
        return this.iRoleRepository.findRolesByRoleName(roleManager);
    }
}
