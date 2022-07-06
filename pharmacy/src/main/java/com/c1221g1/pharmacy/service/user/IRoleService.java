package com.c1221g1.pharmacy.service.user;

import com.c1221g1.pharmacy.entity.user.Roles;

public interface IRoleService {
    Roles findRole(String role_manager);
}
