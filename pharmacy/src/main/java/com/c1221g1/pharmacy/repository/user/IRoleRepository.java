package com.c1221g1.pharmacy.repository.user;

import com.c1221g1.pharmacy.entity.user.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Roles,Integer> {
}
