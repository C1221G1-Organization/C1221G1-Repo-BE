package com.c1221g1.pharmacy.repository.user;

import com.c1221g1.pharmacy.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<Users,String> {
}
