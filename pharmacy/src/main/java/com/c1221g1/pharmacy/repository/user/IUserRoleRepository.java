package com.c1221g1.pharmacy.repository.user;

import com.c1221g1.pharmacy.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRoleRepository extends JpaRepository<UserRole,Integer> {
    @Query(value="insert into user_role(username,role)values (:email,:i)",nativeQuery=true)
    void saveUserRole(String email, int i);
}
