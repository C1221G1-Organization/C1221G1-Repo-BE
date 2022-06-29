package com.c1221g1.pharmacy.repository.user;

import com.c1221g1.pharmacy.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRoleRepository extends JpaRepository<UserRole,Integer> {
}
